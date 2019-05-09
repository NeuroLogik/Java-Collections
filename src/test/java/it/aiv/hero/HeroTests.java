package it.aiv.hero;

import it.aiv.Hero;
import it.aiv.Weapon;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HeroTests
{
	Weapon longSword = new Weapon("Long Sword");
	Weapon warAxe = new Weapon("War Axe");
	Weapon knife = new Weapon("Knife");
	Weapon warHammer = new Weapon("War Hammer");
	Weapon longBow = new Weapon("Long Bow");
	Weapon shortSword = new Weapon("Short Sword");
	Weapon enchantedArrow = new Weapon("Enchanted Arrow");
	Weapon batarang = new Weapon("Batarang");
	Weapon batGrapple = new Weapon("Bat Grapple");
	
	Hero hero1 = new Hero("Conan", 100, Arrays.asList(warAxe, longSword, shortSword, knife));
	Hero hero2 = new Hero("Attila", 70, Arrays.asList(warAxe, warHammer, longBow, longSword, knife));
	Hero hero3 = new Hero("Legolas", 40, Arrays.asList(longBow, shortSword, knife));
	Hero hero4 = new Hero("Merlin", 30, Arrays.asList(enchantedArrow, knife));
	Hero hero5 = new Hero("Batman", 90, Arrays.asList(batarang, batGrapple));
	
	List<Hero> heroes1 = Arrays.asList(hero1, hero2, hero3, hero4, hero5);
	
	@Test
	public void testLists()
	{
		List<Hero> heroes2 = new ArrayList<Hero>();
		heroes2.add(hero1);
		heroes2.add(hero2);
		heroes2.add(hero3);
		heroes2.add(hero4);
		heroes2.add(hero5);
		
		assertEquals(heroes1, heroes2);
	}
	
	@Test
	public void testHeroesOver50Hp()
	{
		List<String> heroesOver50HpKnown = Arrays.asList(hero1._name, hero2._name, hero5._name);
		List<String> heroesOver50HpFound = new ArrayList<String>();
		
		for(Hero h : heroes1)
		{
			if(h._hp > 50)
			{
				heroesOver50HpFound.add(h._name);
			}
		}
		
		assertEquals(heroesOver50HpFound, heroesOver50HpKnown);
	}
	
	@Test
	public void testHeroesAverageHp()
	{
		Hero hero3 = new Hero("AcchioVoi", 40, Arrays.asList(longBow, shortSword));
		
		List<Hero> heroes1 = Arrays.asList(hero1, hero2, hero3, hero4, hero5);
		
		int resKnown = 55;
		int resFound = 0;
		int counter = 0;
		
		for(Hero h : heroes1)
		{
			if(h._name.charAt(0) == 'A')
			{
				resFound += h._hp;
				counter++;
			}
		}
		
		assertEquals(resKnown, resFound / counter);
	}
	
	@Test
	public void testHeroesFirstWeapon()
	{
		Hero hero1 = new Hero("ConanSega", 50, Arrays.asList(warAxe, longSword, knife));
		
		List<Hero> heroes1 = Arrays.asList(hero1, hero2, hero3, hero4, hero5);
		
		Set<Weapon> weaponsKnown = new HashSet<Weapon>();
		weaponsKnown.add(hero1._weapons.get(0));
		weaponsKnown.add(hero3._weapons.get(0));
		weaponsKnown.add(hero4._weapons.get(0));
		
		Set<Weapon> weaponsFound = new HashSet<Weapon>();
		
		for(Hero h : heroes1)
		{
			if(h._hp < 80)
			{
				weaponsFound.add(h._weapons.get(0));
			}
		}
		
		assertEquals(weaponsKnown, weaponsFound);
	}
	
	@Test
	public void testMap()
	{
		Map<Weapon, Integer> weaponsNumKnown = new HashMap<Weapon, Integer>();
		weaponsNumKnown.put(longSword, 2);
		weaponsNumKnown.put(warAxe, 2);
		weaponsNumKnown.put(shortSword, 2);
		weaponsNumKnown.put(knife, 4);
		weaponsNumKnown.put(warHammer, 1);
		weaponsNumKnown.put(longBow, 2);
		weaponsNumKnown.put(enchantedArrow, 1);
		weaponsNumKnown.put(batarang, 1);
		weaponsNumKnown.put(batGrapple, 1);
		
		Map<Weapon, Integer> weaponsNumFound = new HashMap<Weapon, Integer>();
		
		for(Hero h : heroes1)
		{
			for(Weapon w : h._weapons)
			{
				if(weaponsNumFound.containsKey(w))
				{
					int val = weaponsNumFound.get(w);
					weaponsNumFound.replace(w, val, val + 1);
				}
				else
				{
					weaponsNumFound.put(w, 1);
				}
			}
		}
		
		assertEquals(weaponsNumKnown, weaponsNumFound);
	}
}
