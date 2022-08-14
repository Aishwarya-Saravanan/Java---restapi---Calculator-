/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aishu
 */
public class Error {
    private String errorText;
    private int errorCode;

    public String getErrorText() {
        return errorText;
    }
    public int getErrorCode() {
        return errorCode;
    }

    public void setError(int errorCode, String errorText) {
        this.errorCode = errorCode;
        this.errorText = errorText;
    }
}
