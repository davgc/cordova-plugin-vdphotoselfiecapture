//
//  VDPhotoSelfieCapture.h
//  VDPhotoSelfieCapture
//
//  Copyright © 2017 das-nano. All rights reserved.
//

#import <UIKit/UIKit.h>

/**
 @brief Protocol that comunicates this framework with an app/framework/library that uses it.
 @details Currently all methods are required.
 */
@protocol VDPhotoSelfieCaptureProtocol <NSObject>

@required
/**
 @brief Delegate method which will notify when the selfie image is captured.
 @param photoSelfieData (NSData *) Contains the data of the selfie image captured.
 @param face (NSData *) Contains the data of the face cropped contained in the selfie image if possible.
 */
- (void)VDPhotoSelfieCaptured:(NSData*)photoSelfieData andFace: (NSData *) face;
/**
 @brief Delegate method which will notify when a selfie frame is captured.
 @param photoSelfieData (NSData *) Contains the data of the selfie frame captured.
 @param face (NSData *) Contains the data of the face cropped contained in the selfie frame if possible.
 */
- (void) VDPhotoSelfieCapturedWithLiveDetection:(NSData*)photoSelfieData andFace: (NSData *) face;

/**
 @brief Delegate method which will notify when the proccess has finished completely
 @param processFinished (Boolean) Indicates if the process has finish (true) or has been interrupted (false)
 @details This method will be called always at the end of the proccess or when stop has been called when everything is stopped.
 */
- (void)VDPhotoSelfieAllFinished:(Boolean)processFinished;

@end

/**
 @brief Class that contains the main functions of the Framework.
 @details Its the main class of this Framework. The public methods of this class are the ones used to make this Framework work.
 */
@interface VDPhotoSelfieCapture : NSObject

/**
 @brief This method is needed to use the SDK. It programs the delegate to which the SDK will notify the outputs.
 @param delegate (UIViewController <VDPhotoSelfieCaptureProtocol>*) The instance to which the SDK will notify all its outputs.
 @return (UIViewController*) The UIViewController that is shown.
 */
+ (UIViewController*) startWithDelegate: (UIViewController <VDPhotoSelfieCaptureProtocol> *) delegate;

/**
 @brief This method is needed to use the SDK. It programs the delegate to which the SDK will notify the outputs.
 @param delegate (UIViewController <VDPhotoSelfieCaptureProtocol>*) The instance to which the SDK will notify all its outputs.
 @param config (NSDictionary) The configuration of the SDK.
 @return (UIViewController*) The UIViewController that is shown.
 */
+ (UIViewController*) startWithDelegate:(UIViewController<VDPhotoSelfieCaptureProtocol> *)delegate andConfiguration:(NSDictionary*)config;
/**
 @brief This method will stop the SDK and all its functionalities, so it needs to be started again. The SDK will not provide any more outputs after this method and the app flow will be given to the app.
 */
+ (void) stop;

/**
 @brief This method is used to ask the SDK if it is already running
 @returns (BOOL) Whether the SDK is running or not
 */
+ (BOOL) isStarted;

/**
 @brief This method is used to ask for the SDK’s version.
 @returns (NSString *) A string which contains the SDK version
 */
+ (NSString *) getVersion;
/**
 @brief This method is used to ask for the SDK’s configuration keys.
 @returns (NSArray *) An array which contains the SDK configuration keys.
 */
+(NSArray*)getConfigurationKeys;
@end
