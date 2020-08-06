namespace java com.vng.zing.media.mp3.publisher.mw.thrift

include "../../../../zcommon/common/ZMediaCommonLib/thrift/zmedia_common_shared.thrift"
include "../../../../zmp3-new/common/ZMP3Engine/thrift/zmp3_publisher_shared.thrift"

service TPublisherMWReadService {
    i32 exists(1:zmedia_common_shared.TThriftAuth auth, 2:zmp3_publisher_shared.TPublisherAssetReadReq req);

    zmedia_common_shared.TI32ListResult getAssetSlice(1:zmedia_common_shared.TThriftAuth auth, 2:zmp3_publisher_shared.TPublisherAssetReadReq req);
    zmedia_common_shared.TI32Score32ListResult getAssetSliceWithScore(1:zmedia_common_shared.TThriftAuth auth, 2:zmp3_publisher_shared.TPublisherAssetReadReq req);
}

service TPublisherMWWriteService extends TPublisherMWReadService {
    i32 putAsset(1:zmedia_common_shared.TThriftAuth auth, 2:zmp3_publisher_shared.TPublisherAssetWriteReq req);
}