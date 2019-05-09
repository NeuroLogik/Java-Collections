package it.aiv;

import java.util.Arrays;

public class App
{
	public static void main(String[] args)
	{
		Weapon longSword = new Weapon("LongSword");
		Weapon warAxe = new Weapon("WarAxe");
		Hero Conan = new Hero("Conan", 100, Arrays.asList(longSword, warAxe));
		System.out.println(Conan.toString());
	}
}
