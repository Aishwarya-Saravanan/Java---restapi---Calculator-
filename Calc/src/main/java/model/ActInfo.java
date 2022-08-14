/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aishu
 */
public class ActInfo implements Serializable {
    private String errorText;
    private int errorCode;
    private double result;

    public ActInfo () {
        // Default error code is 0. It means that there is no error
        this.errorCode = 0;
    }

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

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
