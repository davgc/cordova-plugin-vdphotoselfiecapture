
#import <UIKit/UIKit.h>
#import <Cordova/CDVAvailability.h>
#import <Cordova/CDVPlugin.h>
#import "VDPhotoSelfieCapture/VDPhotoSelfieCapture.h"

@interface VDWebViewSelfie : UIViewController<VDPhotoSelfieCaptureProtocol>

- (UIViewController *)initWithTarget:(CDVPlugin*)myParent andConfig:(NSMutableDictionary*)config;

- (void) stopFramework;

- (void)VDPhotoSelfieCaptured:(NSData *)photoSelfieData andFace:(NSData *)face;
- (void)VDPhotoSelfieAllFinished:(Boolean)processFinished;

@end
