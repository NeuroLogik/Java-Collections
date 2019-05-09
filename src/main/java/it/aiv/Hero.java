package it.aiv;

import it.aiv.Weapon;
import java.util.List;

public class Hero
{
	public String _name;
	public int _hp;
	public List<Weapon> _weapons;
	
	public Hero(String name, int hp, List<Weapon> weapons)
	{
		_name = name;
		_hp = hp;
		_weapons = weapons;
	}

	@Override
	public String toString() {
		return "Hero called " + _name + " has " + _hp + " hp and the following weapons: " + _weapons.get(0)._name + ", " + _weapons.get(1)._name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _hp;
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
		result = prime * result + ((_weapons == null) ? 0 : _weapons.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hero other = (Hero) obj;
		if (_hp != other._hp)
			return false;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		if (_weapons == null) {
			if (other._weapons != null)
				return false;
		} else if (!_weapons.equals(other._weapons))
			return false;
		return true;
	}
}
