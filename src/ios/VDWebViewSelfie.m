#import "VDWebViewSelfie.h"
#import <VDPhotoSelfieCapture/VDPhotoSelfieCapture.h>
#import "CDVVDPhotoSelfieCapture.h"

@implementation VDWebViewSelfie

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
         
         NSMutableDictionary *config = [NSMutableDictionary new];
         
         [config setValue:@"YES" forKey:@"livephoto"];
         [config setValue:@"YES" forKey:@"closebutton"];
         [config setValue:@"YES" forKey:@"livephotoimage"];
         
        
         
        VDView =  [VDPhotoSelfieCapture startWithDelegate:self andConfiguration:config];
          if (VDView ==nil){
              [self stopFramework];
          }
    }
   
}

// In another place you can stop the process (not recommended).
- (void) stopFramework {
  // Stop it whenever you want.  VDPhotoSelfieCapture.stop();
    NSLog(@"stop Framework");
    [VDPhotoSelfieCapture stop];
    [VDView dismissViewControllerAnimated:NO completion:nil];
    [self dismissViewControllerAnimated:YES completion:nil];
}

- (void)VDPhotoSelfieCaptured:(NSData *)photoSelfieData andFace:(NSData *)face {
    // Do with images as needed.
     [parent VDPhotoSelfieCaptured:photoSelfieData andFace:face];
}
- (void)VDPhotoSelfieCapturedWithLiveDetection:(NSData *)photoSelfieData andFace:(NSData *)face {
    // In case the configuration for "livephoto" is "YES", this is a picture of the person with a more
       //natural pose but with lower quality.
     NSLog(@"live captured");
     [parent VDPhotoSelfieCaptured:photoSelfieData andFace:face];
}

- (void)VDPhotoSelfieAllFinished:(Boolean)processFinished {
    //
    NSLog(@"VDPhotoSelfieAllFinished");
    [self stopFramework];
}


- (void)encodeWithCoder:(nonnull NSCoder *)coder {
    //
}

- (void)traitCollectionDidChange:(nullable UITraitCollection *)previousTraitCollection {
    //
}

- (void)preferredContentSizeDidChangeForChildContentContainer:(nonnull id<UIContentContainer>)container {
    //
}

- (CGSize)sizeForChildContentContainer:(nonnull id<UIContentContainer>)container withParentContainerSize:(CGSize)parentSize {
    //
}

- (void)systemLayoutFittingSizeDidChangeForChildContentContainer:(nonnull id<UIContentContainer>)container {
    //
}

- (void)viewWillTransitionToSize:(CGSize)size withTransitionCoordinator:(nonnull id<UIViewControllerTransitionCoordinator>)coordinator {
    //
}

- (void)willTransitionToTraitCollection:(nonnull UITraitCollection *)newCollection withTransitionCoordinator:(nonnull id<UIViewControllerTransitionCoordinator>)coordinator {
    //
}

- (void)didUpdateFocusInContext:(nonnull UIFocusUpdateContext *)context withAnimationCoordinator:(nonnull UIFocusAnimationCoordinator *)coordinator {
    //
}

- (void)setNeedsFocusUpdate {
    //
}

- (BOOL)shouldUpdateFocusInContext:(nonnull UIFocusUpdateContext *)context {
    //
}

- (void)updateFocusIfNeeded {
    //
}

@end
