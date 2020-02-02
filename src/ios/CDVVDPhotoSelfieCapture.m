#import "CDVVDPhotoSelfieCapture.h"
#import "VDWebViewSelfie.h"
#import <VDPhotoSelfieCapture/VDPhotoSelfieCapture.h>

@implementation CDVVDPhotoSelfieCapture

- (void)pluginInitialize
{
  
}

- (void)start:(CDVInvokedUrlCommand*)command
{
    self.callbackId = command.callbackId;
       
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK
                                            messageAsDictionary:@{@"type":@"msg",@"msg":@"ok"}];
    
    [pluginResult setKeepCallback:[NSNumber numberWithBool:YES]];
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    
    UIViewController* VView;
    VView = [[VDWebView alloc] initWithTarget:self];
    [self.viewController presentViewController:VView animated:YES completion:nil];
   
}

- (void)VDPhotoSelfieCaptured:(NSData *)photoSelfieData andFace:(NSData *)face {
  // Do with image as needed.
    NSLog(@"Face Captured");
    
    NSString* base64Img = [self base64forData:photoSelfieData];
    NSString* base64Face = [self base64forData:face];
   
    
    CDVPluginResult* pluginResult = [CDVPluginResult
                                     resultWithStatus:CDVCommandStatus_OK
                                     messageAsDictionary:@{@"imageData":base64Img,
                                                           @"faceData":base64Face}];
    
    [pluginResult setKeepCallback:[NSNumber numberWithBool:YES]];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:self.callbackId];
    
}



- (NSString*)base64forData:(NSData*)theData {
    const uint8_t* input = (const uint8_t*)[theData bytes];
    NSInteger length = [theData length];

    static char table[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    NSMutableData* data = [NSMutableData dataWithLength:((length + 2) / 3) * 4];
    uint8_t* output = (uint8_t*)data.mutableBytes;

    NSInteger i;
    for (i=0; i < length; i += 3) {
        NSInteger value = 0;
        NSInteger j;
        for (j = i; j < (i + 3); j++) {
            value <<= 8;

            if (j < length) {
                value |= (0xFF & input[j]);
            }
        }

        NSInteger theIndex = (i / 3) * 4;
        output[theIndex + 0] =                    table[(value >> 18) & 0x3F];
        output[theIndex + 1] =                    table[(value >> 12) & 0x3F];
        output[theIndex + 2] = (i + 1) < length ? table[(value >> 6)  & 0x3F] : '=';
        output[theIndex + 3] = (i + 2) < length ? table[(value >> 0)  & 0x3F] : '=';
    }

    return [[NSString alloc] initWithData:data encoding:NSASCIIStringEncoding] ;
}


@end


