var express=require('express'),
    path=require('path'),
    app=express();

app.set('port',3000);

app.use(express.static(path.join(__dirname,'public')));

app.listen(app.get('port'),function(){
  console.log('Listening to port '+app.get('port'));
});
