package communication;

import java.util.List;

public class Message {

    private String uid;
    private String message;
    private MessageType type = MessageType.TEXT;
    private String path;

    private long lat;
    private long lng;
    private String ext;

    private long timestamp;

    private String divId;
    private String vendorId;

    /**
     * The single uid and multiple uids to apply a specific action when the message type is EXIT/DESTROY/INVITE/EXPEL.
     */
    private List<String> applyOns;

    public Message(){

    }

    public Message(String divId, String vendorId) {
        this.divId = divId;
        this.vendorId = vendorId;
    }

    public List<String> getApplyOns() {
        return applyOns;
    }

    public void setApplyOns(List<String> applyOns) {
        this.applyOns = applyOns;
    }

    public String getDivId() {
        return divId;
    }

    public void setDivId(String divId) {
        this.divId = divId;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLng() {
        return lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "uid='" + uid + '\'' +
                ", message='" + message + '\'' +
                ", type=" + type +
                ", path='" + path + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", ext='" + ext + '\'' +
                ", timestamp=" + timestamp +
                ", divId='" + divId + '\'' +
                ", vendorId='" + vendorId + '\'' +
                ", applyOns=" + applyOns +
                '}';
    }
}