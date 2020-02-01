
var exec = require('cordova/exec');
//var channel = require('cordova/channel');

var PLUGIN_NAME = 'CDVVDPhotoSelfieCapture';




var VDPhotoSelfieCapture = {

  start: function (onSuccess, onError) {
    exec(onSuccess, onError, PLUGIN_NAME, 'start', []);
  }
}


module.exports = VDPhotoSelfieCapture;


