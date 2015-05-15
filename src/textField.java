
/*Boolean ok = true;
        int kundeNr;
        try
        {
            String søk = søkefelt.getText();
            if(!match(regexNr,søk))
                ok = false;
            if(ok)
                kundeNr = Integer.parseInt(søk);
            else
            {
                output2.setText("Feil input, bruk kun nummer");
                søkefelt.setText("");
                return;
            }
            Kunde kunden = register.finnKundeInt(kundeNr);
            if(kunden !=null)
            {
                output2.setText(kunden.toString());
                k=kunden;
                finnForsikringer(k);
            }
            else
            {
                output2.setText("Finnes ingen kunder med dette kundenummeret");
            }
            søkefelt.setText("");
        }
        catch(NullPointerException npe)
        {
            søkefelt.setText("");
            output2.setText("Exception please doddodo");
        }*/