#import "VDWebViewSelfie.h"
#import <VDPhotoSelfieCapture/VDPhotoSelfieCapture.h>
#import "CDVVDPhotoSelfieCapture.h"

@implementation VDWebViewSelfie

UIViewController* VDView;

CDVVDPhotoSelfieCapture* parent;
NSMutableDictionary* _config;

- (UIViewController *)initWithTarget:(CDVVDPhotoSelfieCapture*)myParent andConfig:(NSMutableDictionary*)config
{
    parent = myParent;
    _config = config;
    return self;
}

- (void) viewDidAppear:(BOOL)animated {

     if(![VDPhotoSelfieCapture isStarted]){
        // Start with configuration can be done
         
         NSMutableDictionary *config = [NSMutableDictionary new];
         if (_config != nil){
             config = _config;
         }
                      
        VDView =  [VDPhotoSelfieCapture startWithDelegate:self andConfiguration:_config];
          if (VDView ==nil){
              //no cam
              [self stopFramework];
          }
    }
   
}

// In another place you can stop the process (not recommended).
- (void) stopFramework {
  // Stop it whenever you want.  VDPhotoSelfieCapture.stop();
    NSLog(@"stop Framework");
    [VDPhotoSelfieCapture stop];
    [VDView dismissViewControllerAnimated:YES completion:nil];
    [self dismissViewControllerAnimated:YES completion:nil];
}

- (void)VDPhotoSelfieCaptured:(NSData *)photoSelfieData andFace:(NSData *)face {
    // Do with images as needed.
    NSLog(@"standard selfie captured");
    [parent VDPhotoSelfieCaptured:photoSelfieData andFace:face andType:@"REGULAR"];
}

- (void)VDPhotoSelfieCapturedWithLiveDetection:(NSData *)photoSelfieData andFace:(NSData *)face {
    // In case the configuration for "livephoto" is "YES", this is a picture of the person with a more
       //natural pose but with lower quality.
     NSLog(@"live selfie captured");
    [parent VDPhotoSelfieCaptured:photoSelfieData andFace:face andType:@"LIVE"];
}

- (void)VDPhotoSelfieAllFinished:(Boolean)processFinished {
    //
    NSLog(@"VDPhotoSelfieAllFinished");
     [parent VDPhotoSelfieAllFinished:processFinished];
    [self stopFramework];
}


@end
