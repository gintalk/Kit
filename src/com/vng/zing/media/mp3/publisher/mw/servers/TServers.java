/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.publisher.mw.servers;

import com.vng.zing.media.mp3.publisher.mw.handlers.TPublisherMWWriteHandler;
import com.vng.zing.media.mp3.publisher.mw.thrift.TPublisherMWWriteService;
import com.vng.zing.thriftserver.ThriftServers;

/**
 *
 * @author namnq
 */
public class TServers {

	public boolean setupAndStart() {
		ThriftServers servers = new ThriftServers("main");
		          TPublisherMWWriteService.Processor processor = new TPublisherMWWriteService.Processor(new TPublisherMWWriteHandler("main"));
		servers.setup(processor);
		return servers.start();
	}
}
