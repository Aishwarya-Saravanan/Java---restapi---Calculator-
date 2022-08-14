/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Aishu
 */
public class Output {
    private final String actionName;
    private final double result;

    public Output(String actionName, double result) {
        this.actionName = actionName;
        this.result = result;
    }

    public String getActionName() {
        return actionName;
    }
    public double getResult() {
        return result;
    }
}
