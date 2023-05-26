package com.gemini.database.config;

public class DBConfig {

    private String vendor;
    private String driverClass;
    private String host;
    private String port;
    private String databaseName;
    private String schemaName;
    private String userName;
    private String password;
    private String url;

    public String createURL() {
	return this.url == null ? null : String.format(url, host, databaseName);
    }

    public String getVendor() {
	return vendor;
    }

    public void setVendor(String vendor) {
	this.vendor = vendor;
    }

    public String getDriverClass() {
	return driverClass;
    }

    public void setDriverClass(String driverClass) {
	this.driverClass = driverClass;
    }

    public String getHost() {
	return host;
    }

    public void setHost(String host) {
	this.host = host;
    }

    public String getPort() {
	return port;
    }

    public void setPort(String port) {
	this.port = port;
    }

    public String getDatabaseName() {
	return databaseName;
    }

    public void setDatabaseName(String databaseName) {
	this.databaseName = databaseName;
    }

    public String getSchemaName() {
	return schemaName;
    }

    public void setSchemaName(String schemaName) {
	this.schemaName = schemaName;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("DBConfig [vendor=");
	builder.append(vendor);
	builder.append(", driverClass=");
	builder.append(driverClass);
	builder.append(", host=");
	builder.append(host);
	builder.append(", port=");
	builder.append(port);
	builder.append(", databaseName=");
	builder.append(databaseName);
	builder.append(", schemaName=");
	builder.append(schemaName);
	builder.append(", userName=");
	builder.append(userName);
	builder.append(", password=");
	builder.append(password);
	builder.append(", url=");
	builder.append(url);
	builder.append("]");
	return builder.toString();
    }

}
