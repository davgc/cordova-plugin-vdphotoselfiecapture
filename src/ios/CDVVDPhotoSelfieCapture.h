#import <Cordova/CDVPlugin.h>

@interface CDVVDPhotoSelfieCapture : CDVPlugin {
}

@property (nonatomic, copy) NSString* callbackId;
  
- (void)start:(CDVInvokedUrlCommand*)command;

- (void)VDPhotoSelfieCaptured:(NSData *)photoSelfieData andFace:(NSData *)face andType:(NSString *)imgType;

- (void)VDPhotoSelfieAllFinished:(Boolean)processFinished;

@end

