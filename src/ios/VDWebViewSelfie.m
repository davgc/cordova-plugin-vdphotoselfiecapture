#import "VDWebViewSelfie.h"

#import <VDPhotoSelfieCapture/VDPhotoSelfieCapture.h>
#import "CDVVDPhotoSelfieCapture.h"

@implementation VDWebView

UIViewController* VDView;

CDVVDPhotoSelfieCapture* parent;

- (UIViewController *)initWithTarget:(CDVVDPhotoSelfieCapture*)myParent
{
    parent = myParent;
    return self;
    
}

- (void) viewDidAppear:(BOOL)animated {


     if(![VDPhotoSelfieCapture isStarted]){
        // Start with configuration can be done
       
        VDView =  [VDPhotoSelfieCapture startWithDelegate:self];

          
          if (VDView ==nil){
              [self stopFramework];
          }
    }
   
    
}

// In another place you can stop the process (not recommended).
- (void) stopFramework {
  // Stop it whenever you want.  VDPhotoSelfieCapture.stop();
    [VDPhotoSelfieCapture stop];
    [VDView dismissViewControllerAnimated:NO completion:nil];
    [self dismissViewControllerAnimated:YES completion:nil];
}
// // Protocol methods.
// // Called when a document image has been captured
// - (void) VDDocumentCaptured:(NSData *) imageData withCaptureType:(VDCaptureType) captureType
//       andDocument:(NSArray<VDDocument *> *) document {
//   // Do with image as needed.
//     //NSLog(@"Document Captured");
//     [parent VDDocumentCaptured:imageData withCaptureType:captureType andDocument:document];
    
// }
// // Called when the framework has finished.
// // processFinished (Boolean) Indicates if the process has finish (true) or has been interrupted (false)
// - (void) VDDocumentAllFinished:(Boolean)processFinished {
//     // When the framework ends, proceed as needed.
//      NSLog(@"Document Finished");
//     [self stopFramework];
// }
// // Called when the number of seconds passed without taking the photo.
// - (void) VDTimeWithoutPhotoTaken:(int)seconds withCaptureType:(VDCaptureType)capture {
//    // Action may be needed.
//      NSLog(@"Not taken ");
//     [parent VDTimeWithoutPhotoTaken:seconds withCaptureType:capture];
//     [self stopFramework];
// }

- (void)VDPhotoSelfieCaptured:(NSData *)photoSelfieData andFace:(NSData *)face {
    // Do with images as needed.
     [parent VDPhotoSelfieCaptured:imageData andFace:face];
}
- (void)VDPhotoSelfieCapturedWithLiveDetection:(NSData *)photoSelfieData andFace:(NSData *)face {
    // In case the configuration for "livephoto" is "YES", this is a picture of the person with a more
       //natural pose but with lower quality.
}
// Called when the framework has finished.
- (void)VDPhotoSelfieAllFinished {
    // End of framework.
     [self stopFramework];
}




@end
