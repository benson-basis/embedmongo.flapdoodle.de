/**
 * Copyright (C) 2011
 *   Michael Mosmann <michael@mosmann.de>
 *   Martin Jöhren <m.joehren@googlemail.com>
 *
 * with contributions from
 * 	konstantin-ba@github,Archimedes Trajano (trajano@github)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.flapdoodle.embed.mongo.config;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import de.flapdoodle.embed.mongo.config.AbstractMongoConfig.Net;
import de.flapdoodle.embed.mongo.config.AbstractMongoConfig.Storage;
import de.flapdoodle.embed.mongo.config.AbstractMongoConfig.Timeout;
import de.flapdoodle.embed.process.config.ExecutableProcessConfig;
import de.flapdoodle.embed.process.distribution.IVersion;
import de.flapdoodle.embed.process.runtime.Network;

/**
 *
 */
public class MongosConfig extends AbstractMongoConfig {

	private final String configDB;

	public MongosConfig(IVersion version, String configDB) throws UnknownHostException, IOException {
		this(version, new Net(Network.getFreeServerPort(), Network.localhostIsIPv6()), new Timeout(), configDB);
	}

	public MongosConfig(IVersion version, Net network, Timeout timeout, String configDB) {
		super(version,network,timeout);
		this.configDB = configDB; 
	}

	public String getConfigDB() {
		return configDB;
	}
	
	public static MongosConfig getConfigInstance(IVersion version, Net network,String configDB) {
		return new MongosConfig(version, network, new Timeout(),configDB);
	}


//
//	public InetAddress getServerAddress() throws UnknownHostException {
//		if (bindIp!=null) {
//			return InetAddress.getByName(bindIp);
//		}
//		return Network.getLocalHost();
//	}

}