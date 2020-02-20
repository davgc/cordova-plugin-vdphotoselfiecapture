
var exec = require('cordova/exec');
//var channel = require('cordova/channel');

var PLUGIN_NAME = 'CDVVDPhotoSelfieCapture';




var VDPhotoSelfieCapture = {

  start: function (config, onSuccess, onError) {
    exec(onSuccess, onError, PLUGIN_NAME, 'start', [config]);
  }
}


module.exports = VDPhotoSelfieCapture;


