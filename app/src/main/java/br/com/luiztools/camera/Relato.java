package br.com.luiztools.camera;

import java.io.Serializable;

public class Relato implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String text;

    public Relato(){ this(null, null);}

    public Relato(Long id, String text){
        this.setId(id);
        this.setText(text);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
