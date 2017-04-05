package com.mycompany;

import org.apache.camel.builder.RouteBuilder;

public class MessageSelectorRoute extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("jms:ORDER?selector=LOCATION='Hvidovre'").to("jms:queue:ORDERHVIDOVRE");
		from("jms:ORDER?selector=LOCATION='Amager'").to("jms:queue:ORDERAMAGER");
                from("jms:ORDER?selector=LOCATION='Horsholm'").to("jms:queue:ORDERHORSHOLM");
                from("jms:ORDER?selector=LOCATION='Rodovre'").to("jms:queue:ORDERRODOVRE");
                from("jms:ORDER?selector=LOCATION='Brondby'").to("jms:queue:ORDERBRONDBY");
	}
}
