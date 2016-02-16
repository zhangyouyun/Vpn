package android.com.vpn;

/**
 * Created by Auser on 2016/1/19.
 */
public class Item {
    private String ip;
    private String type;
    private Boolean isButton;
    private Boolean isTogglebutton;
    private Boolean isEdittext;

    private String textName;
    private int itemId;
    private int textColor;
    private String edHint;
    private String edText;
    private int textSize;
    private Boolean isOpened=true;
    private String buttonName;
    private String buttonText;
    private String ipText;
    private String portText;
    private String aaa;

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public void setIpText(String ipText) {
        this.ipText = ipText;
    }

    public void setPortText(String portText) {
        this.portText = portText;
    }

    public String getIpText() {
        return ipText;
    }

    public String getPortText() {
        return portText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getButtonText() {
        return buttonText;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public void setIsOpened(Boolean isOpened) {
        this.isOpened = isOpened;
    }

    public Boolean getIsOpened() {
        return isOpened;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIsButton(Boolean isButton) {
        this.isButton = isButton;
    }

    public void setIsTogglebutton(Boolean isTogglebutton) {
        this.isTogglebutton = isTogglebutton;
    }

    public void setIsEdittext(Boolean isEdittext) {
        this.isEdittext = isEdittext;
    }

    public String getIp() {
        return ip;
    }

    public String getType() {
        return type;
    }

    public Boolean getIsButton() {
        return isButton;
    }

    public Boolean getIsTogglebutton() {
        return isTogglebutton;
    }

    public Boolean getIsEdittext() {
        return isEdittext;
    }



    public String getTextName() {
        return textName;
    }

    public int getItemId() {
        return itemId;
    }

    public int getTextColor() {
        return textColor;
    }

    public boolean isButton() {
        return isButton;
    }


    public String getEdHint() {
        return edHint;
    }

    public String getEdText() {
        return edText;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public void setIsButton(boolean isButton) {
        this.isButton = isButton;
    }

    public void setEdHint(String edHint) {
        this.edHint = edHint;
    }

    public void setEdText(String edText) {
        this.edText = edText;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }
}
