package com.jetty;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

public class JettyServer {
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		Server server = new Server();
		Connector connector = new org.mortbay.jetty.nio.SelectChannelConnector();

		connector.setHost(args != null && args.length > 0 ? args[0] : "localhost");
		connector.setPort(args != null && args.length > 1 ? Integer.parseInt(args[1]) : 8080);
		connector.setMaxIdleTime(30000);
		connector.setStatsOn(false);
		connector.setLowResourceMaxIdleTime(5000);

		// 定义上下文
		WebAppContext webapp = new WebAppContext();
		webapp.setContextPath("/ordershop");
		webapp.setWar(args != null && args.length > 2 ? args[2] : "./WebRoot");

		// 这个是默认的web.xml配置。下面两行可以注释掉
		webapp.setDefaultsDescriptor("./jetty/etc/webdefault.xml");
		server.setStopAtShutdown(true);
		server.setHandler(webapp);

		// InputStream resourceAsStream =
		// JettyLauncher.class.getClassLoader().getResourceAsStream("jetty-config.xml");
		// System.out.println(resourceAsStream);
		// XmlConfiguration configuration = new
		// XmlConfiguration(resourceAsStream);
		// server.setDefaultsDescriptor("src/test/resources/webdefault.xml");
		// configuration.configure(server);
		server.addConnector(connector);
		server.start();
		System.out.println("Jetty started in " + (System.currentTimeMillis() - start) + " ms.");
	}
}
