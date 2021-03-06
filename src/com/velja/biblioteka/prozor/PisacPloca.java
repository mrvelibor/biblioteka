package com.velja.biblioteka.prozor;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.velja.biblioteka.Biblioteka;
import com.velja.biblioteka.prozor.dijalog.Dijalog;
import com.velja.biblioteka.prozor.komponente.Dugme;
import com.velja.biblioteka.prozor.komponente.Ploca;
import com.velja.biblioteka.prozor.komponente.Tekst;

@SuppressWarnings("serial")
public class PisacPloca extends Ploca {

	private final Dugme mDodaj, mObrisi, mIzmeni;

	public PisacPloca() {
		super();
		setLayout(new GridLayout(2, 1));
		add(new Tekst("PISAC", Tekst.CENTER));

		Ploca ploca = new Ploca();
		ploca.setLayout(new GridLayout(1, 2));
		{
			Ploca ploca1 = new Ploca();
			ploca1.setLayout(new GridLayout(2, 1));
			{
				mIzmeni = new Dugme("Izmeni");
				mIzmeni.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Dijalog.izmeniPisca();
					}
				});
				mIzmeni.setEnabled(false);
				ploca1.add(mIzmeni);

				mObrisi = new Dugme("Obri�i");
				mObrisi.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(Dijalog.potvrda("", "Obrisati pisca " + Biblioteka.getPisac() + "?", Dijalog.NE) == 0) Biblioteka.remove(Biblioteka.getPisac());
					}
				});
				mObrisi.setEnabled(false);
				ploca1.add(mObrisi);
			}
			ploca.add(ploca1);

			mDodaj = new Dugme("Dodaj");
			mDodaj.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Dijalog.dodajPisca();
				}
			});
			ploca.add(mDodaj);

		}
		add(ploca);
	}

	public void setButton(boolean b) {
		mObrisi.setEnabled(b);
		mIzmeni.setEnabled(b);
	}

}
