/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.api.TRadioHomeSection;
import com.vng.zing.media.mp3.common.thrift.api.TRadioHomeSectionLayout;
import com.vng.zing.media.mp3.common.thrift.api.TRadioHomeSectionType;
import com.vng.zing.media.mp3.engine.model.ERadioHomeSectionModel;
import java.util.Arrays;

/**
 *
 * @author namnh16
 */
public class EModelTest extends BaseTest {
    
    private static final ERadioHomeSectionModel rhsModel = ERadioHomeSectionModel.INST;

    public static void main(String[] args) {
//        System.out.println(rhsModel.setLayout(
//                new TRadioHomeSectionLayout(
//                        1, 
//                        Arrays.asList(
//                                new TRadioHomeSection(TRadioHomeSectionType.LIVE, false, true),
//                                new TRadioHomeSection(TRadioHomeSectionType.BANNERS, false, false),
//                                new TRadioHomeSection(TRadioHomeSectionType.BY_GENRE, true, false),
//                                new TRadioHomeSection(TRadioHomeSectionType.BY_ARTIST, false, true)
//                        )
//                )
//        ));
        
        for(TRadioHomeSection section: rhsModel.getLayout().sections){
            System.out.println(ThriftUtils.getStructAsString(section));
        }
    }
}
