#import <Cordova/CDVPlugin.h>
#import <VDDocumentCapture/VDDocumentCapture.h>


@interface CDVVDPhotoSelfieCapture : CDVPlugin {
}

@property (nonatomic, copy) NSString* callbackId;
  
- (void)start:(CDVInvokedUrlCommand*)command;

- (void)VDPhotoSelfieCaptured:(NSData *)photoSelfieData andFace:(NSData *)face;


@end

