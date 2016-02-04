'use strict';

angular.module('containersApp',['ui.bootstrap'])
  .controller('MainCtrl',function($scope, Endpoint, $uibModal, $log){
      $scope.hostname=window.location.hostname;

      var refresh=function(){
        Endpoint.containers().then(function(containers){
            $scope.containers=containers.data;
            $scope.error=false;
        },function(){
            $scope.error=true;
        });
      }

      refresh();

      $scope.delete=function(id){
        Endpoint.delete(id).then(function(){
            refresh();
        });
      }

      $scope.update=function(container){
        var modalInstance = $uibModal.open({
          animation: $scope.animationsEnabled,
          templateUrl: 'views/update.html',
          controller: 'UpdateCtrl',
          resolve: {
            container: function () {
              return container;
            }
          }
        });

        modalInstance.result.then(function(container) {
          Endpoint.update(container).then(function(){
              refresh();
          });
        }, function () {
          $log.info('Modal dismissed at: ' + new Date());
        });
      }

      $scope.create=function(){
        var modalInstance = $uibModal.open({
          animation: $scope.animationsEnabled,
          templateUrl: 'views/create.html',
          controller: 'CreateCtrl'
        });

        modalInstance.result.then(function(container) {
          Endpoint.create(container).then(function(){
              refresh();
          });
        }, function () {
          $log.info('Modal dismissed at: ' + new Date());
        });
      }

  })
  .controller('UpdateCtrl',function($scope, $uibModalInstance, container){
    $scope.container=container;

    $scope.cancel=function(){
        $uibModalInstance.dismiss();
    }

    $scope.update=function(){
      $uibModalInstance.close($scope.container);
    }
  })
  .controller('CreateCtrl',function($scope, $uibModalInstance){
    $scope.cancel=function(){
        $uibModalInstance.dismiss();
    }

    $scope.create=function(){
      $uibModalInstance.close($scope.container);
    }
  });
