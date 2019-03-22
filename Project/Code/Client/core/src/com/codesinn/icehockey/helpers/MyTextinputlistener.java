package com.codesinn.icehockey.helpers;


import com.badlogic.gdx.Input;

public class MyTextinputlistener implements Input.TextInputListener {
    @Override
    public void input (String text) {

        System.out.println(text);

    }

    @Override
    public void canceled () {


    }
}

/* on the child class

 MyTextinputlistener listener = new MyTextinputlistener();
                Gdx.input.getTextInput(listener, "Dialog Title", "","");



 */