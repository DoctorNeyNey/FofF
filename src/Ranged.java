
public abstract class Ranged extends Weapon{
	
	//EACH WEAPONS EQUIVALENT NUMBER IS BASICALLY ITS ID THAT CAN BE USED TO ACCESS ITS 
	//INFORMATION FROM EACH SETS ARRAY
	
	//RATE OF FIRE AND RELOAD SPEED ARE IN MILISECONDS BETWEEN EACH SHOT AND DURATION,
	//RESPECTIVELY
	
	//MAGAZINE SIZE AND MAX AMMO ARE IN NUMBER OF ROUNDS
	
	//FIRE MODES :0 IS SEMI-AUTOMATIC
	//			1 IS AUTOMATIC
	
	
	//PISTOLS
	public static final int M1911 = 0;
	public static final int M1911_RATE_OF_FIRE = 300;
	public static final int M1911_RELOAD_SPEED = 1200;
	public static final int M1911_MAGAZINE_SIZE = 8;
	public static final int M1911_MAX_AMMO = 72;
	public static final int M1911_FIRE_MODE = 0;
	public static final String M1911_NAME = "M1911";
	//public static final int M1911_PLAYER_MOVESPEED = ;
	
	public static final int M9 = 1;
	public static final int M9_RATE_OF_FIRE = 275;
	public static final int M9_RELOAD_SPEED = 1300;
	public static final int M9_MAGAZINE_SIZE = 12;
	public static final int M9_MAX_AMMO = 108;
	public static final int M9_FIRE_MODE = 0;
	public static final String M9_NAME = "M9";
	//public static final int M9_PLAYER_MOVESPEED = ;

	public static final int GLOCK18 = 2;
	public static final int GLOCK18_RATE_OF_FIRE = 50;
	public static final int GLOCK18_RELOAD_SPEED = 1500;
	public static final int GLOCK18_MAGAZINE_SIZE = 17;
	public static final int GLOCK18_MAX_AMMO = 119;
	public static final int GLOCK18_FIRE_MODE = 1;
	public static final String GLOCK18_NAME = "GLOCK 18";

	//public static final int GLOCK18_PLAYER_MOVESPEED = ;

	public static final int BENELLI = 3;
	public static final int BENELLI_RATE_OF_FIRE = 300;
	public static final int BENELLI_RELOAD_SPEED = 1100;
	public static final int BENELLI_MAGAZINE_SIZE = 7;
	public static final int BENELLI_MAX_AMMO = 84;
	public static final int BENELLI_FIRE_MODE = 0;
	public static final String BENELLI_NAME = "BENELLI";
	//public static final int BENELLI_PLAYER_MOVESPEED = ;

	public static final int MAGNUM = 4;
	public static final int MAGNUM_RATE_OF_FIRE = 500;
	public static final int MAGNUM_RELOAD_SPEED = 1900;
	public static final int MAGNUM_MAGAZINE_SIZE = 6;
	public static final int MAGNUM_MAX_AMMO = 42;
	public static final int MAGNUM_FIRE_MODE = 0;
	public static final String MAGNUM_NAME = "MAGNUM";
	//public static final int MAGNUM_PLAYER_MOVESPEED = ;

	public static final int DEAGLE = 5;
	public static final int DEAGLE_RATE_OF_FIRE = 425;
	public static final int DEAGLE_RELOAD_SPEED = 1400;
	public static final int DEAGLE_MAGAZINE_SIZE = 7;
	public static final int DEAGLE_MAX_AMMO = 49;
	public static final int DEAGLE_FIRE_MODE = 0;
	public static final String DEAGLE_NAME = "DEAGLE";
	//public static final int DEAGLE_PLAYER_MOVESPEED = ;


	//SUBMACHINE GUNS
	public static final int MP9 = 6;
	public static final int MP9_RATE_OF_FIRE = 66;
	public static final int MP9_RELOAD_SPEED = 2400;
	public static final int MP9_MAGAZINE_SIZE = 25;
	public static final int MP9_MAX_AMMO = 125;
	public static final int MP9_FIRE_MODE = 1;
	public static final String MP9_NAME = "MP9";
	//public static final int MP9_PLAYER_MOVESPEED = ;

	public static final int THOMPSON = 7;
	public static final int THOMPSON_RATE_OF_FIRE = 91;
	public static final int THOMPSON_RELOAD_SPEED = 3500;
	public static final int THOMPSON_MAGAZINE_SIZE = 50;
	public static final int THOMPSON_MAX_AMMO = 250;
	public static final int THOMPSON_FIRE_MODE = 1;
	public static final String THOMPSON_NAME = "TOMMY GUN";
	//public static final int THOMPSON_PLAYER_MOVESPEED = ;

	public static final int SCORPION = 8;
	public static final int SCORPION_RATE_OF_FIRE = 52;
	public static final int SCORPION_RELOAD_SPEED = 2200;
	public static final int SCORPION_MAGAZINE_SIZE = 20;
	public static final int SCORPION_MAX_AMMO = 160;
	public static final int SCORPION_FIRE_MODE = 1;
	public static final String SCORPION_NAME = "SCORPION";
	//public static final int SCORPION_PLAYER_MOVESPEED = ;

	public static final int UMP45 = 9;
	public static final int UMP45_RATE_OF_FIRE = 92;
	public static final int UMP45_RELOAD_SPEED = 3000;
	public static final int UMP45_MAGAZINE_SIZE = 40;
	public static final int UMP45_MAX_AMMO = 160;
	public static final int UMP45_FIRE_MODE = 1;
	public static final String UMP45_NAME = "UMP 45";
	//public static final int UMP45_PLAYER_MOVESPEED = ;

	public static final int UZI = 10;
	public static final int UZI_RATE_OF_FIRE = 100;
	public static final int UZI_RELOAD_SPEED = 2200;
	public static final int UZI_MAGAZINE_SIZE = 32;
	public static final int UZI_MAX_AMMO = 192;
	public static final int UZI_FIRE_MODE = 1;
	public static final String UZI_NAME = "UZI";
	//public static final int UZI_PLAYER_MOVESPEED = ;

	public static final int VECTOR = 11;
	public static final int VECTOR_RATE_OF_FIRE = 50;
	public static final int VECTOR_RELOAD_SPEED = 2600;
	public static final int VECTOR_MAGAZINE_SIZE = 30;
	public static final int VECTOR_MAX_AMMO = 150;
	public static final int VECTOR_FIRE_MODE = 1;
	public static final String VECTOR_NAME = "VECTOR";
	//public static final int VECTOR_MAGAZINE_SIZEPLAYER_MOVESPEED = ;


	//SHOTGUNS
	public static final int REMINGTON870 = 12;
	public static final int REMINGTON870_RATE_OF_FIRE = 550;
	//public static final int REMINGTON870_RELOAD_SPEED = ;
	public static final int REMINGTON870_MAGAZINE_SIZE = 6;
	public static final int REMINGTON870_MAX_AMMO = 48;
	public static final int REMINGTON870_FIRE_MODE = 0;
	public static final String REMINGTON870_NAME = "REMINGTON 870";
	//public static final int REMINGTON870_PLAYER_MOVESPEED = ;

	public static final int ARMSEL_STRIKER = 13;
	public static final int ARMSEL_STRIKER_RATE_OF_FIRE = 500;
	//public static final int ARMSEL_STRIKER_RELOAD_SPEED = ;
	public static final int ARMSEL_STRIKER_MAGAZINE_SIZE = 12;
	public static final int ARMSEL_STRIKER_MAX_AMMO = 96;
	public static final int ARMSEL_STRIKER_FIRE_MODE = 0;
	public static final String ARMSEL_STRIKER_NAME = "ARMSEL STRIKER";
	//public static final int ARMSEL_STRIKER_PLAYER_MOVESPEED = ;

	public static final int USAS12 = 14;
	public static final int USAS12_RATE_OF_FIRE = 350;
	public static final int USAS12_RELOAD_SPEED = 2500;
	public static final int USAS12_MAGAZINE_SIZE = 10;
	public static final int USAS12_MAX_AMMO = 70;
	public static final int USAS12_FIRE_MODE = 1;
	public static final String USAS12_NAME = "USAS 12";
	//public static final int USAS12_PLAYER_MOVESPEED = ;

	public static final int SAWED_OFF = 15;
	public static final int SAWED_OFF_RATE_OF_FIRE = 300;
	public static final int SAWED_OFF_RELOAD_SPEED = 1500;
	public static final int SAWED_OFF_MAGAZINE_SIZE = 2;
	public static final int SAWED_OFF_MAX_AMMO = 28;
	public static final int SAWED_OFF_FIRE_MODE = 0;	
	public static final String SAWED_OFF_NAME = "SAWED-OFF";
	//public static final int SAWED_OFF_PLAYER_MOVESPEED = ;

	public static final int SPAS12 = 16;
	public static final int SPAS12_RATE_OF_FIRE = 850;
	//public static final int SPAS12_RELOAD_SPEED = ;
	public static final int SPAS12_MAGAZINE_SIZE = 7;
	public static final int SPAS12_MAX_AMMO = 56;
	public static final int SPAS12_FIRE_MODE = 0;
	public static final String SPAS12_NAME = "SPAS12";
	//public static final int SPAS12_PLAYER_MOVESPEED = ;


	//ASSAULT RIFLES
	public static final int AEK971 = 17;
	public static final int AEK971_RATE_OF_FIRE = 66;
	public static final int AEK971_RELOAD_SPEED = 3600;
	public static final int AEK971_MAGAZINE_SIZE = 30;
	public static final int AEK971_MAX_AMMO = 210;
	public static final int AEK971_FIRE_MODE = 1;
	public static final String AEK971_NAME = "AEK971";
	//public static final int AEK971_PLAYER_MOVESPEED = ;

	public static final int AR15 = 18;
	public static final int AR15_RATE_OF_FIRE = 80;
	public static final int AR15_RELOAD_SPEED = 2800;
	public static final int AR15_MAGAZINE_SIZE = 20;
	public static final int AR15_MAX_AMMO = 180;
	public static final int AR15_FIRE_MODE = 0;
	public static final String AR15_NAME = "AR 15";
	//public static final int AR15_PLAYER_MOVESPEED = ;

	public static final int AK47 = 19;
	public static final int AK47_RATE_OF_FIRE = 100;
	public static final int AK47_RELOAD_SPEED = 3300;
	public static final int AK47_MAGAZINE_SIZE = 30;
	public static final int AK47_MAX_AMMO = 240;
	public static final int AK47_FIRE_MODE = 1;
	public static final String AK47_NAME = "AK 47";
	//public static final int AK47_PLAYER_MOVESPEED = ;

	public static final int M4A1 = 20;
	public static final int M4A1_RATE_OF_FIRE = 72;
	public static final int M4A1_RELOAD_SPEED = 3100;
	public static final int M4A1_MAGAZINE_SIZE = 30;
	public static final int M4A1_MAX_AMMO = 240;
	public static final int M4A1_FIRE_MODE = 1;
	public static final String M4A1_NAME = "M4A1";
	
	//public static final int AK47_PLAYER_MOVESPEED = ;

	public static final int SR47 = 21;
	public static final int SR47_RATE_OF_FIRE = 75;
	public static final int SR47_RELOAD_SPEED = 3400;
	public static final int SR47_MAGAZINE_SIZE = 30;
	public static final int SR47_MAX_AMMO = 240;
	public static final int SR47_FIRE_MODE = 1;
	public static final String SR47_NAME = "SR 47";

	//public static final int SR47_PLAYER_MOVESPEED = ;


	//LIGHT MACHINE GUNS
	public static final int BROWNING = 22;
	public static final int BROWNING_RATE_OF_FIRE = 110;
	public static final int BROWNING_RELOAD_SPEED = 7600;
	public static final int BROWNING_MAGAZINE_SIZE = 150;
	public static final int BROWNING_MAX_AMMO = 300;
	public static final int BROWNING_FIRE_MODE = 1;
	public static final String BROWNING_NAME = "BROWNING";
	//public static final int BROWNING_PLAYER_MOVESPEED = ;

	public static final int L86 = 23;
	public static final int L86_RATE_OF_FIRE = 80;
	public static final int L86_RELOAD_SPEED = 4800;
	public static final int L86_MAGAZINE_SIZE = 80;
	public static final int L86_MAX_AMMO = 240;
	public static final int L86_FIRE_MODE = 1;
	public static final String L86_NAME = "L86";
	//public static final int L86_PLAYER_MOVESPEED = ;
	
	public static final int TYPE99 = 24;
	public static final int TYPE99_RATE_OF_FIRE = 90;
	public static final int TYPE99_RELOAD_SPEED = 6000;
	public static final int TYPE99_MAGAZINE_SIZE = 60;
	public static final int TYPE99_MAX_AMMO = 240;
	public static final int TYPE99_FIRE_MODE = 1;
	public static final String TYPE99_NAME = "TYPE 99";
	//public static final int TYPE99_PLAYER_MOVESPEED = ;
	
	public static final int FN_MAG = 25;
	public static final int FN_MAG_RATE_OF_FIRE = 73;
	public static final int FN_MAG_RELOAD_SPEED = 5500;
	public static final int FN_MAG_MAGAZINE_SIZE = 125;
	public static final int FN_MAG_MAX_AMMO = 350;
	public static final int FN_MAG_FIRE_MODE = 1;
	public static final String FN_MAG_NAME = "FN MAG";
	//public static final int FN_MAG_PLAYER_MOVESPEED = ;
	
	
	//SNIPER RIFLES
	public static final int ALEJANDRO = 26;
	public static final int ALEJANDRO_RATE_OF_FIRE = 900;
	public static final int ALEJANDRO_RELOAD_SPEED = 3000;
	public static final int ALEJANDRO_MAGAZINE_SIZE = 8;
	public static final int ALEJANDRO_MAX_AMMO = 40;
	public static final int ALEJANDRO_FIRE_MODE = 0;
	public static final String ALEJANDRO_NAME = "ALEJANDRO";
	//public static final int ALEJANDRO_PLAYER_MOVESPEED = ;
		
	public static final int BARRETT50 = 27;
	public static final int BARRETT50_RATE_OF_FIRE = 550;
	public static final int BARRETT50_RELOAD_SPEED = 4500;
	public static final int BARRETT50_MAGAZINE_SIZE = 10;
	public static final int BARRETT50_MAX_AMMO = 50;
	public static final int BARRETT50_FIRE_MODE = 0;
	public static final String BARRETT50_NAME = "BARRETT .50CAL";
	//public static final int BARRET50_PLAYER_MOVESPEED = ;
	
	public static final int DRAGUNOV = 28;
	public static final int DRAGUNOV_RATE_OF_FIRE = 850;
	public static final int DRAGUNOV_RELOAD_SPEED = 3500;
	public static final int DRAGUNOV_MAGAZINE_SIZE = 9;
	public static final int DRAGUNOV_MAX_AMMO = 45;
	public static final int DRAGUNOV_FIRE_MODE = 0;
	public static final String DRAGUNOV_NAME = "DRAGUNOV";
	//public static final int DRAGUNOV_PLAYER_MOVESPEED = ;
	
	public static final int SV98 = 29;
	public static final int SV98_RATE_OF_FIRE = 900;
	public static final int SV98_RELOAD_SPEED = 4750;
	public static final int SV98_MAGAZINE_SIZE = 10;
	public static final int SV98_MAX_AMMO = 50;
	public static final int SV98_FIRE_MODE = 0;
	public static final String SV98_NAME = "SV 98";
	//public static final int SV98_PLAYER_MOVESPEED = ;
	
	
	//SPECIAL
	public static final int GRENADE_LAUNCHER = 30;
	public static final int GRENADE_LAUNCHER_RATE_OF_FIRE = 750;
	//public static final int GRENADE_LAUNCHER_RELOAD_SPEED = ;
	public static final int GRENADE_LAUNCHER_MAGAZINE_SIZE = 4;
	public static final int GRENADE_LAUNCHER_MAX_AMMO = 16;
	public static final int GRENADE_LAUNCHER_FIRE_MODE = 0;
	public static final String GRENADE_LAUNCHER_NAME = "GRENADE LAUNCHER";
	//public static final int GRENADE_LAUNCHER_PLAYER_MOVESPEED = ;
	
	public static final int RPG = 31;
	public static final int RPG_RATE_OF_FIRE = 250;
	public static final int RPG_RELOAD_SPEED = 1750;
	public static final int RPG_MAGAZINE_SIZE = 1;
	public static final int RPG_MAX_AMMO = 5;
	public static final int RPG_FIRE_MODE = 0;
	public static final String RPG_NAME = "RPG";
	//public static final int RPG_PLAYER_MOVESPEED = ;
	
	public static final int MINIGUN = 32;
	public static final int MINIGUN_RATE_OF_FIRE = 25;
	public static final int MINIGUN_RELOAD_SPEED = 7500;
	public static final int MINIGUN_MAGAZINE_SIZE = 250;
	public static final int MINIGUN_MAX_AMMO = 500;
	public static final int MINIGUN_FIRE_MODE = 1;
	public static final String MINIGUN_NAME = "MINIGUN";
	//public static final int MINIGUN_PLAYER_MOVESPEED = ;
	
	public static final int CROSSBOW = 33;
	public static final int CROSSBOW_RATE_OF_FIRE = 250;
	public static final int CROSSBOW_RELOAD_SPEED = 1450;
	public static final int CROSSBOW_MAGAZINE_SIZE = 1;
	public static final int CROSSBOW_MAX_AMMO = 32;
	public static final int CROSSBOW_FIRE_MODE = 0;
	public static final String CROSSBOW_NAME = "CROSSBOW";
	//public static final int CROSSBOW_PLAYER_MOVESPEED = ;
	
	
	//I REALIZED INSTEAD OF A CASE AND SWITCH IN EVERY SCENARIO WE CAN JUST USE A SINGLE
	//ARRAY AND ACCESS THE INFORMATION MUCH EASIER

	public static final int[] magSizes = {
			M1911_MAGAZINE_SIZE,
			M9_MAGAZINE_SIZE,
			GLOCK18_MAGAZINE_SIZE,
			BENELLI_MAGAZINE_SIZE,
			MAGNUM_MAGAZINE_SIZE,
			DEAGLE_MAGAZINE_SIZE,
			MP9_MAGAZINE_SIZE,
			THOMPSON_MAGAZINE_SIZE,
			SCORPION_MAGAZINE_SIZE,
			UMP45_MAGAZINE_SIZE,
			UZI_MAGAZINE_SIZE,
			VECTOR_MAGAZINE_SIZE,
			REMINGTON870_MAGAZINE_SIZE,
			ARMSEL_STRIKER_MAGAZINE_SIZE,
			USAS12_MAGAZINE_SIZE,
			SAWED_OFF_MAGAZINE_SIZE,
			SPAS12_MAGAZINE_SIZE,
			AEK971_MAGAZINE_SIZE,
			AR15_MAGAZINE_SIZE,
			AK47_MAGAZINE_SIZE,
			M4A1_MAGAZINE_SIZE,
			SR47_MAGAZINE_SIZE,
			BROWNING_MAGAZINE_SIZE,
			L86_MAGAZINE_SIZE,
			TYPE99_MAGAZINE_SIZE,
			FN_MAG_MAGAZINE_SIZE,
			ALEJANDRO_MAGAZINE_SIZE,
			BARRETT50_MAGAZINE_SIZE,
			DRAGUNOV_MAGAZINE_SIZE,
			SV98_MAGAZINE_SIZE,
			GRENADE_LAUNCHER_MAGAZINE_SIZE,
			RPG_MAGAZINE_SIZE,
			MINIGUN_MAGAZINE_SIZE,
			CROSSBOW_MAGAZINE_SIZE
	};
	
	public static final int[] reloadSpeeds = {
			M1911_RELOAD_SPEED,
			M9_RELOAD_SPEED,
			GLOCK18_RELOAD_SPEED,
			BENELLI_RELOAD_SPEED,
			MAGNUM_RELOAD_SPEED,
			DEAGLE_RELOAD_SPEED,
			MP9_RELOAD_SPEED,
			THOMPSON_RELOAD_SPEED,
			SCORPION_RELOAD_SPEED,
			UMP45_RELOAD_SPEED,
			UZI_RELOAD_SPEED,
			VECTOR_RELOAD_SPEED,
			1,//REMINGTON870_RELOAD_SPEED,
			1,//ARMSEL_STRIKER_RELOAD_SPEED,
			USAS12_RELOAD_SPEED,
			SAWED_OFF_RELOAD_SPEED,
			1,//SPAS12_RELOAD_SPEED,
			AEK971_RELOAD_SPEED,
			AR15_RELOAD_SPEED,
			AK47_RELOAD_SPEED,
			M4A1_RELOAD_SPEED,
			SR47_RELOAD_SPEED,
			BROWNING_RELOAD_SPEED,
			L86_RELOAD_SPEED,
			TYPE99_RELOAD_SPEED,
			FN_MAG_RELOAD_SPEED,
			ALEJANDRO_RELOAD_SPEED,
			BARRETT50_RELOAD_SPEED,
			DRAGUNOV_RELOAD_SPEED,
			SV98_RELOAD_SPEED,
			1,//GRENADE_LAUNCHER_RELOAD_SPEED,
			RPG_RELOAD_SPEED,
			MINIGUN_RELOAD_SPEED,
			CROSSBOW_RELOAD_SPEED
	};
	
	public static final int[] fireRates = {
			M1911_RATE_OF_FIRE,
			M9_RATE_OF_FIRE,
			GLOCK18_RATE_OF_FIRE,
			BENELLI_RATE_OF_FIRE,
			MAGNUM_RATE_OF_FIRE,
			DEAGLE_RATE_OF_FIRE,
			MP9_RATE_OF_FIRE,
			THOMPSON_RATE_OF_FIRE,
			SCORPION_RATE_OF_FIRE,
			UMP45_RATE_OF_FIRE,
			UZI_RATE_OF_FIRE,
			VECTOR_RATE_OF_FIRE,
			REMINGTON870_RATE_OF_FIRE,
			ARMSEL_STRIKER_RATE_OF_FIRE,
			USAS12_RATE_OF_FIRE,
			SAWED_OFF_RATE_OF_FIRE,
			SPAS12_RATE_OF_FIRE,
			AEK971_RATE_OF_FIRE,
			AR15_RATE_OF_FIRE,
			AK47_RATE_OF_FIRE,
			M4A1_RATE_OF_FIRE,
			SR47_RATE_OF_FIRE,
			BROWNING_RATE_OF_FIRE,
			L86_RATE_OF_FIRE,
			TYPE99_RATE_OF_FIRE,
			FN_MAG_RATE_OF_FIRE,
			ALEJANDRO_RATE_OF_FIRE,
			BARRETT50_RATE_OF_FIRE,
			DRAGUNOV_RATE_OF_FIRE,
			SV98_RATE_OF_FIRE,
			GRENADE_LAUNCHER_RATE_OF_FIRE,
			RPG_RATE_OF_FIRE,
			MINIGUN_RATE_OF_FIRE,
			CROSSBOW_RATE_OF_FIRE
	};
	
	public static final int[] maxAmmoStashes = {
			M1911_MAX_AMMO,
			M9_MAX_AMMO,
			GLOCK18_MAX_AMMO,
			BENELLI_MAX_AMMO,
			MAGNUM_MAX_AMMO,
			DEAGLE_MAX_AMMO,
			MP9_MAX_AMMO,
			THOMPSON_MAX_AMMO,
			SCORPION_MAX_AMMO,
			UMP45_MAX_AMMO,
			UZI_MAX_AMMO,
			VECTOR_MAX_AMMO,
			REMINGTON870_MAX_AMMO,
			ARMSEL_STRIKER_MAX_AMMO,
			USAS12_MAX_AMMO,
			SAWED_OFF_MAX_AMMO,
			SPAS12_MAX_AMMO,
			AEK971_MAX_AMMO,
			AR15_MAX_AMMO,
			AK47_MAX_AMMO,
			M4A1_MAX_AMMO,
			SR47_MAX_AMMO,
			BROWNING_MAX_AMMO,
			L86_MAX_AMMO,
			TYPE99_MAX_AMMO,
			FN_MAG_MAX_AMMO,
			ALEJANDRO_MAX_AMMO,
			BARRETT50_MAX_AMMO,
			DRAGUNOV_MAX_AMMO,
			SV98_MAX_AMMO,
			GRENADE_LAUNCHER_MAX_AMMO,
			RPG_MAX_AMMO,
			MINIGUN_MAX_AMMO,
			CROSSBOW_MAX_AMMO
	};
	
	public static final int[] fireModes = {
			M1911_FIRE_MODE,
			M9_FIRE_MODE,
			GLOCK18_FIRE_MODE,
			BENELLI_FIRE_MODE,
			MAGNUM_FIRE_MODE,
			DEAGLE_FIRE_MODE,
			MP9_FIRE_MODE,
			THOMPSON_FIRE_MODE,
			SCORPION_FIRE_MODE,
			UMP45_FIRE_MODE,
			UZI_FIRE_MODE,
			VECTOR_FIRE_MODE,
			REMINGTON870_FIRE_MODE,
			ARMSEL_STRIKER_FIRE_MODE,
			USAS12_FIRE_MODE,
			SAWED_OFF_FIRE_MODE,
			SPAS12_FIRE_MODE,
			AEK971_FIRE_MODE,
			AR15_FIRE_MODE,
			AK47_FIRE_MODE,
			M4A1_FIRE_MODE,
			SR47_FIRE_MODE,
			BROWNING_FIRE_MODE,
			L86_FIRE_MODE,
			TYPE99_FIRE_MODE,
			FN_MAG_FIRE_MODE,
			ALEJANDRO_FIRE_MODE,
			BARRETT50_FIRE_MODE,
			DRAGUNOV_FIRE_MODE,
			SV98_FIRE_MODE,
			GRENADE_LAUNCHER_FIRE_MODE,
			RPG_FIRE_MODE,
			MINIGUN_FIRE_MODE,
			CROSSBOW_FIRE_MODE
	};
	
	public static final String[] weaponNames = {
			M1911_NAME,
			M9_NAME,
			GLOCK18_NAME,
			BENELLI_NAME,
			MAGNUM_NAME,
			DEAGLE_NAME,
			MP9_NAME,
			THOMPSON_NAME,
			SCORPION_NAME,
			UMP45_NAME,
			UZI_NAME,
			VECTOR_NAME,
			REMINGTON870_NAME,
			ARMSEL_STRIKER_NAME,
			USAS12_NAME,
			SAWED_OFF_NAME,
			SPAS12_NAME,
			AEK971_NAME,
			AR15_NAME,
			AK47_NAME,
			M4A1_NAME,
			SR47_NAME,
			BROWNING_NAME,
			L86_NAME,
			TYPE99_NAME,
			FN_MAG_NAME,
			ALEJANDRO_NAME,
			BARRETT50_NAME,
			DRAGUNOV_NAME,
			SV98_NAME,
			GRENADE_LAUNCHER_NAME,
			RPG_NAME,
			MINIGUN_NAME,
			CROSSBOW_NAME
	};
}