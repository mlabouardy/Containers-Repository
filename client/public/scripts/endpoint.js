'use strict';

angular.module('containersApp')
  .factory('Endpoint',function($http){
    var SERVER='http://localhost:9090';
    return{
      containers:function(){
        return $http.get(SERVER+'/containers');
      },
      create:function(container){
        return $http.post(SERVER+'/containers', container);
      },
      delete:function(id){
        return $http.delete(SERVER+'/containers?id='+id);
      },
      update:function(container){
        return $http.put(SERVER+'/containers',container);
      }
    }
  });
