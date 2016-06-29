var express = require('express');
var bodyParser = require('body-parser')

var app = express();

app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});

app.use(bodyParser.json());



app.post('/teste', function (req, res) {
  
  var json = {"alert":"funcionando"}

  res.send(json);
});

app.listen(3000, function () {
  console.log('Running on localhost:3000 !');
});
