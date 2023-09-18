package com.example.monitor;

public class Connections {
    String Appname;
    String Protocol;
    String source;
    String destination;
    String SNI;
    String status;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    int image;

    public Connections(String appname, String protocol, String source, String destination, String SNI, String status) {
        Appname = appname;
        Protocol = protocol;
        this.source = source;
        this.destination = destination;
        this.SNI = SNI;
        this.status = status;
    }

    public String getAppname() {
        return Appname;
    }

    public void setAppname(String appname) {
        Appname = appname;
    }

    public String getProtocol() {
        return Protocol;
    }

    public void setProtocol(String protocol) {
        Protocol = protocol;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSNI() {
        return SNI;
    }

    public void setSNI(String SNI) {
        this.SNI = SNI;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
