///////////////////////////////
/////John Brandenburg/////////
//////////MDF3 1502///////////

package com.bbgatestudios.widgetapp;

import java.io.Serializable;


public class Contact implements Serializable {

    private static final long serialVersionUID = 517116325584636891L;

    private String fName;
    private String lName;
    private String mEmail;
    private String mPhone;

    public Contact(){
        fName = "";
        lName = "";
        mEmail = "";
        mPhone = "";
    }

    public Contact(String first, String last, String email, String phone){
        fName = first;
        lName = last;
        mEmail = email;
        mPhone = phone;
    }

    public String getName(){return fName + " " + lName; }

    public String getFirst(){ return fName; }
    public void setFirst(String fName){ this.fName = fName; }

    public String getLast(){ return lName; }
    public void setLast(String lName){ this.lName = lName; }

    public String getEmail(){ return mEmail; }
    public void setEmail(String mEmail){ this.mEmail = mEmail; }

    public String getPhone(){ return mPhone; }
    public void setPhone(String mPhone){ this.mPhone = mPhone; }
}

