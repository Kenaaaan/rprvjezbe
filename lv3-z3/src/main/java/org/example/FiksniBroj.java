package org.example;

import java.util.Objects;

public class FiksniBroj extends TelefonskiBroj{
    private Grad grad;
    private String broj;

    public FiksniBroj(Grad grad, String broj){
        if(null==grad) throw new BrojException("Broj ne valja");
        this.grad=grad;
        this.broj=broj;
    }
    public String ispisi() {
        if (grad != null && broj != null) {
            return grad.getPozitivniBroj() + "/" + broj;
        } else {
            return null;
        }
    }
    public int hashCode(){return Objects.hash(grad,broj);
    }
    public Grad getGrad(){return grad;}
    public String getBroj(){return broj;}
}
