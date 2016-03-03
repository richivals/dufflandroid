package com.tetearent.util;

import java.util.ArrayList;
import java.util.HashMap;

public class StaticVal {

	public static ArrayList<String[]> APPAREL_MEN_STYLE_LIST = new ArrayList<String[]>();
	public static ArrayList<String[]> FOOTWEAR_MEN_STYLE_LIST = new ArrayList<String[]>();
	public static ArrayList<String[]> WEDDING_MEN_STYLE_LIST = new ArrayList<String[]>();
	
	public static ArrayList<String[]> APPAREL_WOMEN_STYLE_LIST = new ArrayList<String[]>();
	public static ArrayList<String[]> FOOTWEAR_WOMEN_STYLE_LIST = new ArrayList<String[]>();
	public static ArrayList<String[]> WEDDING_WOMEN_STYLE_LIST = new ArrayList<String[]>();
	
	//MAPS
	public static ArrayList<HashMap<String, String>> APPAREL_MEN_STYLE_LIST_MAP = new ArrayList<HashMap<String,String>>();
	public static ArrayList<HashMap<String, String>> FOOTWEAR_MEN_STYLE_LIST_MAP = new ArrayList<HashMap<String,String>>();
	public static ArrayList<HashMap<String, String>> WEDDING_MEN_STYLE_LIST_MAP = new ArrayList<HashMap<String,String>>();
	
	public static ArrayList<HashMap<String, String>> APPAREL_WOMEN_STYLE_LIST_MAP = new ArrayList<HashMap<String,String>>();
	public static ArrayList<HashMap<String, String>> FOOTWEAR_WOMEN_STYLE_LIST_MAP = new ArrayList<HashMap<String,String>>();
	public static ArrayList<HashMap<String, String>> WEDDING_WOMEN_STYLE_LIST_MAP = new ArrayList<HashMap<String,String>>();

	public static void init() {
		APPAREL_MEN_STYLE_LIST.add(APPAREL_SHIRTS_MEN_STYLE);
		APPAREL_MEN_STYLE_LIST.add(APPAREL_T_SHIRTS_MEN_STYLE);
		APPAREL_MEN_STYLE_LIST.add(APPAREL_TOPS_POLOS_MEN_STYLE);
		APPAREL_MEN_STYLE_LIST.add(APPAREL_HOODIES_SWEATSHIRTS_MEN_STYLE);
		APPAREL_MEN_STYLE_LIST.add(APPAREL_JUMPERS_CARDIGANS_MEN_STYLE);
		APPAREL_MEN_STYLE_LIST.add(APPAREL_COATS_JACKETS_MEN_STYLE);
		APPAREL_MEN_STYLE_LIST.add(APPAREL_SUITS_BLAZERS_MEN_STYLE);
		APPAREL_MEN_STYLE_LIST.add(APPAREL_BOTTOMS_MEN_STYLE);
		APPAREL_MEN_STYLE_LIST.add(APPAREL_ATHLETIC_MEN_STYLE);
		
		APPAREL_MEN_STYLE_LIST_MAP.add(APPAREL_SHIRTS_STYLE_MEN_MAP);
		APPAREL_MEN_STYLE_LIST_MAP.add(APPAREL_T_SHIRTS_MEN_STYLE_MAP);
		APPAREL_MEN_STYLE_LIST_MAP.add(APPAREL_TOPS_POLOS_MEN_STYLE_MAP);
		APPAREL_MEN_STYLE_LIST_MAP.add(APPAREL_HOODIES_SWEATSHIRTS_MEN_STYLE_MAP);
		APPAREL_MEN_STYLE_LIST_MAP.add(APPAREL_JUMPERS_CARDIGANS_MEN_STYLE_MAP);
		APPAREL_MEN_STYLE_LIST_MAP.add(APPAREL_COATS_JACKETS_MEN_STYLE_MAP);
		APPAREL_MEN_STYLE_LIST_MAP.add(APPAREL_SUITS_BLAZERS_MEN_STYLE_MAP);
		APPAREL_MEN_STYLE_LIST_MAP.add(APPAREL_BOTTOMS_MEN_STYLE_MAP);
		APPAREL_MEN_STYLE_LIST_MAP.add(APPAREL_ATHLETIC_MEN_STYLE_MAP);

		FOOTWEAR_MEN_STYLE_LIST.add(FOOTWEAR_FOOTWEAR_MEN_STYLE);
		FOOTWEAR_MEN_STYLE_LIST.add(FOOTWEAR_BAG_MEN_STYLE);
		FOOTWEAR_MEN_STYLE_LIST.add(FOOTWEAR_ACCESSORIES_MEN_STYLE);
		
		FOOTWEAR_MEN_STYLE_LIST_MAP.add(FOOTWEAR_FOOTWEAR_MEN_STYLE_MAP);
		FOOTWEAR_MEN_STYLE_LIST_MAP.add(FOOTWEAR_BAG_MEN_STYLE_MAP);
		FOOTWEAR_MEN_STYLE_LIST_MAP.add(FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP);

		WEDDING_MEN_STYLE_LIST.add(WEDDING_TOPS_MEN_STYLE);
		WEDDING_MEN_STYLE_LIST.add(WEDDING_BOTTOMS_MEN_STYLE);
		WEDDING_MEN_STYLE_LIST.add(WEDDING_FULLSETS_MEN_STYLE);
		WEDDING_MEN_STYLE_LIST.add(WEDDING_FOOTWEAR_MEN_STYLE);
		WEDDING_MEN_STYLE_LIST.add(WEDDING_HEADWEAR_MEN_STYLE);
		
		WEDDING_MEN_STYLE_LIST_MAP.add(WEDDING_TOPS_MEN_STYLE_MAP);
		WEDDING_MEN_STYLE_LIST_MAP.add(WEDDING_BOTTOMS_MEN_STYLE_MAP);
		WEDDING_MEN_STYLE_LIST_MAP.add(WEDDING_FULLSETS_MEN_STYLE_MAP);
		WEDDING_MEN_STYLE_LIST_MAP.add(WEDDING_FOOTWEAR_MEN_STYLE_MAP);
		WEDDING_MEN_STYLE_LIST_MAP.add(WEDDING_HEADWEAR_MEN_STYLE_MAP);
		
		APPAREL_WOMEN_STYLE_LIST.add(APPAREL_TOPS_WOMEN_STYLE);
		APPAREL_WOMEN_STYLE_LIST.add(APPAREL_DRESSES_WOMEN_STYLE);
		APPAREL_WOMEN_STYLE_LIST.add(APPAREL_OUTERWEAR_WOMEN_STYLE);
		APPAREL_WOMEN_STYLE_LIST.add(APPAREL_ACTIVEWEAR_WOMEN_STYLE);
		APPAREL_WOMEN_STYLE_LIST.add(APPAREL_SWIM_WOMEN_STYLE);
		APPAREL_WOMEN_STYLE_LIST.add(APPAREL_BOTTOMS_WOMEN_STYLE);
		APPAREL_WOMEN_STYLE_LIST.add(APPAREL_JEANS_WOMEN_STYLE);
		APPAREL_WOMEN_STYLE_LIST.add(APPAREL_SUITING_WOMEN_STYLE);
		APPAREL_WOMEN_STYLE_LIST.add(APPAREL_SARIS_WOMEN_STYLE);
		APPAREL_WOMEN_STYLE_LIST.add(APPAREL_SALWARKAMEEZ_WOMEN_STYLE);
		
		APPAREL_WOMEN_STYLE_LIST_MAP.add(APPAREL_TOPS_WOMEN_STYLE_MAP);
		APPAREL_WOMEN_STYLE_LIST_MAP.add(APPAREL_DRESSES_WOMEN_STYLE_MAP);
		APPAREL_WOMEN_STYLE_LIST_MAP.add(APPAREL_OUTERWEAR_WOMEN_STYLE_MAP);
		APPAREL_WOMEN_STYLE_LIST_MAP.add(APPAREL_ACTIVEWEAR_WOMEN_STYLE_MAP);
		APPAREL_WOMEN_STYLE_LIST_MAP.add(APPAREL_SWIM_WOMEN_STYLE_MAP);
		APPAREL_WOMEN_STYLE_LIST_MAP.add(APPAREL_BOTTOMS_WOMEN_STYLE_MAP);
		APPAREL_WOMEN_STYLE_LIST_MAP.add(APPAREL_JEANS_WOMEN_STYLE_MAP);
		APPAREL_WOMEN_STYLE_LIST_MAP.add(APPAREL_SUITING_WOMEN_STYLE_MAP);
		APPAREL_WOMEN_STYLE_LIST_MAP.add(APPAREL_SARIS_WOMEN_STYLE_MAP);
		APPAREL_WOMEN_STYLE_LIST_MAP.add(APPAREL_SALWARKAMEEZ_WOMEN_STYLE_MAP);
		
		FOOTWEAR_WOMEN_STYLE_LIST.add(FOOTWEAR_FOOTWEAR_WOMEN_STYLE);
		FOOTWEAR_WOMEN_STYLE_LIST.add(FOOTWEAR_BAGS_WOMEN_STYLE);
		FOOTWEAR_WOMEN_STYLE_LIST.add(FOOTWEAR_ACCESSORIES_WOMEN_STYLE);
		
		FOOTWEAR_WOMEN_STYLE_LIST_MAP.add(FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP);
		FOOTWEAR_WOMEN_STYLE_LIST_MAP.add(FOOTWEAR_BAGS_WOMEN_STYLE_MAP);
		FOOTWEAR_WOMEN_STYLE_LIST_MAP.add(FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP);
		
		WEDDING_WOMEN_STYLE_LIST.add(WEDDING_WEDDINGDRESSES_WOMEN_STYLE);
		WEDDING_WOMEN_STYLE_LIST.add(WEDDING_WEDDINGVEILS_WOMEN_STYLE);
		WEDDING_WOMEN_STYLE_LIST.add(WEDDING_WEDDINGJEWELLERY_WOMEN_STYLE);
		WEDDING_WOMEN_STYLE_LIST.add(WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE);
		
		WEDDING_WOMEN_STYLE_LIST_MAP.add(WEDDING_WEDDINGDRESSES_WOMEN_STYLE_MAP);
		WEDDING_WOMEN_STYLE_LIST_MAP.add(WEDDING_WEDDINGVEILS_WOMEN_STYLE_MAP);
		WEDDING_WOMEN_STYLE_LIST_MAP.add(WEDDING_WEDDINGJEWELLERY_WOMEN_STYLE_MAP);
		WEDDING_WOMEN_STYLE_LIST_MAP.add(WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE_MAP);
	}

	public static final String[] COLOR = { "Aquamarine", "Beige", "Black",
			"Blue", "Blue Green", "Blue Violet", "Brass", "Bronze", "Brown",
			"Burgundy", "Burnt Orange", "Carrot orange", "Charcoal",
			"Chocolate", "Copper", "Cream", "Crimson", "Denim", "Fern green",
			"Firebrick", "Fuchsia", "Gold", "Green", "Grey", "Indigo", "Ivory",
			"Khaki", "Lavender", "Lemon", "Lilac", "Lime green", "Magenta",
			"Maroon", "Mauve", "Midnight Blue", "Mustard", "Navy Blue",
			"Olive", "Orange", "Peach", "Pink", "Platinum", "Plum", "Purple",
			"Red", "Rose", "Royal blue", "Royal purple", "Rust", "Saffron",
			"Salmon", "Sea Green", "Sepia", "Shocking Pink", "Silver",
			"Sky Blue", "Slate grey", "Tan", "Teal", "Turquoise", "Vermilion",
			"Violet", "White", "Yellow", "Multicolor" };
	public static final HashMap<String, String> COLOR_MAP;
	static {
		COLOR_MAP = new HashMap<String, String>();
		COLOR_MAP.put("Aquamarine", "13");
		COLOR_MAP.put("Beige", "15");
		COLOR_MAP.put("Black", "14");
		COLOR_MAP.put("Blue", "92");
		COLOR_MAP.put("Blue Green", "91");
		COLOR_MAP.put("Blue Violet", "90");
		COLOR_MAP.put("Brass", "89");
		COLOR_MAP.put("Bronze", "88");
		COLOR_MAP.put("Brown", "87");
		COLOR_MAP.put("Burgundy", "86");
		COLOR_MAP.put("Burnt Orange", "85");
		COLOR_MAP.put("Carrot orange", "84");
		COLOR_MAP.put("Charcoal", "83");
		COLOR_MAP.put("Chocolate", "82");
		COLOR_MAP.put("Copper", "81");
		COLOR_MAP.put("Cream", "80");
		COLOR_MAP.put("Crimson", "79");
		COLOR_MAP.put("Denim", "78");
		COLOR_MAP.put("Fern green", "77");
		COLOR_MAP.put("Firebrick", "76");
		COLOR_MAP.put("Fuchsia", "75");
		COLOR_MAP.put("Gold", "74");
		COLOR_MAP.put("Green", "73");
		COLOR_MAP.put("Grey", "72");
		COLOR_MAP.put("Indigo", "71");
		COLOR_MAP.put("Ivory", "70");
		COLOR_MAP.put("Khaki", "69");
		COLOR_MAP.put("Lavender", "68");
		COLOR_MAP.put("Lemon", "67");
		COLOR_MAP.put("Lilac", "66");
		COLOR_MAP.put("Lime green", "65");
		COLOR_MAP.put("Magenta", "64");
		COLOR_MAP.put("Maroon", "63");
		COLOR_MAP.put("Mauve", "62");
		COLOR_MAP.put("Midnight Blue", "61");
		COLOR_MAP.put("Mustard", "60");
		COLOR_MAP.put("Navy Blue", "59");
		COLOR_MAP.put("Olive", "58");
		COLOR_MAP.put("Orange", "57");
		COLOR_MAP.put("Peach", "56");
		COLOR_MAP.put("Pink", "55");
		COLOR_MAP.put("Platinum", "54");
		COLOR_MAP.put("Plum", "53");
		COLOR_MAP.put("Purple", "52");
		COLOR_MAP.put("Red", "51");
		COLOR_MAP.put("Rose", "50");
		COLOR_MAP.put("Royal blue", "49");
		COLOR_MAP.put("Royal purple", "48");
		COLOR_MAP.put("Rust", "47");
		COLOR_MAP.put("Saffron", "46");
		COLOR_MAP.put("Salmon", "45");
		COLOR_MAP.put("Sea Green", "44");
		COLOR_MAP.put("Sepia", "43");
		COLOR_MAP.put("Shocking Pink", "42");
		COLOR_MAP.put("Silver", "41");
		COLOR_MAP.put("Sky Blue", "40");
		COLOR_MAP.put("Slate grey", "39");
		COLOR_MAP.put("Tan", "38");
		COLOR_MAP.put("Teal", "37");
		COLOR_MAP.put("Turquoise", "36");
		COLOR_MAP.put("Vermilion", "35");
		COLOR_MAP.put("Violet", "34");
		COLOR_MAP.put("White", "33");
		COLOR_MAP.put("Yellow", "32");
		COLOR_MAP.put("Multicolor", "105");
	}

	// ITEM
	public static final String[] ITEM_CATEGORY = { "Apparel",
			"Footwear, Bags and Accessories", "Wedding" };
	public static final HashMap<String, String> ITEM_CATEGORY_MAP_MEN;
	static {
		ITEM_CATEGORY_MAP_MEN = new HashMap<String, String>();
		ITEM_CATEGORY_MAP_MEN.put("Apparel", "189");
		ITEM_CATEGORY_MAP_MEN.put("Footwear, Bags and Accessories", "190");
		ITEM_CATEGORY_MAP_MEN.put("Wedding", "191");
	}
	
	public static final HashMap<String, String> ITEM_CATEGORY_MAP_WOMEN;
	static {
		ITEM_CATEGORY_MAP_WOMEN = new HashMap<String, String>();
		ITEM_CATEGORY_MAP_WOMEN.put("Apparel", "3");
		ITEM_CATEGORY_MAP_WOMEN.put("Footwear, Bags and Accessories", "4");
		ITEM_CATEGORY_MAP_WOMEN.put("Wedding", "17");
	}

	// ITEM TYPE
	public static final String[] APPAREL_TYPE_MEN = { "Shirts", "T Shirts",
			"Tops & Polos", "Hoodies & Sweatshirts", "Jumpers & Cardigans",
			"Coats & Jackets", "Suits & Blazers", "Bottoms", "Athletic" };
	public static final HashMap<String, String> APPAREL_TYPE_MEN_MAP;
	static {
		APPAREL_TYPE_MEN_MAP = new HashMap<String, String>();
		APPAREL_TYPE_MEN_MAP.put("Shirts", "192");
		APPAREL_TYPE_MEN_MAP.put("T Shirts", "193");
		APPAREL_TYPE_MEN_MAP.put("Tops & Polos", "200");
		APPAREL_TYPE_MEN_MAP.put("Hoodies & Sweatshirts", "205");
		APPAREL_TYPE_MEN_MAP.put("Jumpers & Cardigans", "208");
		APPAREL_TYPE_MEN_MAP.put("Coats & Jackets", "211");
		APPAREL_TYPE_MEN_MAP.put("Suits & Blazers", "214");
		APPAREL_TYPE_MEN_MAP.put("Bottoms", "217");
		APPAREL_TYPE_MEN_MAP.put("Athletic", "234");
	}

	public static final String[] FOOTWEAR_TYPE = { "Footwear", "Bags",
			"Accessories" };
	public static final HashMap<String, String> FOOTWEAR_TYPE_MAP;
	static {
		FOOTWEAR_TYPE_MAP = new HashMap<String, String>();
		FOOTWEAR_TYPE_MAP.put("Footwear", "225");
		FOOTWEAR_TYPE_MAP.put("Bags", "232");
		FOOTWEAR_TYPE_MAP.put("Accessories", "233");
	}

	public static final String[] WEDDING_TYPE_MEN = { "Tops", "Bottoms",
			"Full Sets", "Footwear", "Headwear" };
	public static final HashMap<String, String> WEDDING_TYPE_MEN_MAP;
	static {
		WEDDING_TYPE_MEN_MAP = new HashMap<String, String>();
		WEDDING_TYPE_MEN_MAP.put("Tops", "260");
		WEDDING_TYPE_MEN_MAP.put("Bottoms", "261");
		WEDDING_TYPE_MEN_MAP.put("Full Sets", "262");
		WEDDING_TYPE_MEN_MAP.put("Footwear", "276");
		WEDDING_TYPE_MEN_MAP.put("Headwear", "287");
	}

	// STYLE SHIRTS - APPAREL
	public static final String[] APPAREL_SHIRTS_MEN_STYLE = { "Half Sleeve",
			"Full Sleeve" };
	public static final HashMap<String, String> APPAREL_SHIRTS_STYLE_MEN_MAP;
	static {
		APPAREL_SHIRTS_STYLE_MEN_MAP = new HashMap<String, String>();
		APPAREL_SHIRTS_STYLE_MEN_MAP.put("Half Sleeve", "198");
		APPAREL_SHIRTS_STYLE_MEN_MAP.put("Full Sleeve", "199");
	}

	// STYLE T SHIRTS - APPAREL
	public static final String[] APPAREL_T_SHIRTS_MEN_STYLE = { "Round Neck",
			"Collar", "V Neck", "Cowl Neck" };
	public static final HashMap<String, String> APPAREL_T_SHIRTS_MEN_STYLE_MAP;
	static {
		APPAREL_T_SHIRTS_MEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_T_SHIRTS_MEN_STYLE_MAP.put("Round Neck", "194");
		APPAREL_T_SHIRTS_MEN_STYLE_MAP.put("Collar", "195");
		APPAREL_T_SHIRTS_MEN_STYLE_MAP.put("V Neck", "196");
		APPAREL_T_SHIRTS_MEN_STYLE_MAP.put("Cowl Neck", "197");

	}

	// STYLE TOPS AND POLOS - APPAREL
	public static final String[] APPAREL_TOPS_POLOS_MEN_STYLE = { "Polos",
			"Tops", "Vests", "Kurtas" };
	public static final HashMap<String, String> APPAREL_TOPS_POLOS_MEN_STYLE_MAP;
	static {
		APPAREL_TOPS_POLOS_MEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_TOPS_POLOS_MEN_STYLE_MAP.put("Polos", "201");
		APPAREL_TOPS_POLOS_MEN_STYLE_MAP.put("Tops", "202");
		APPAREL_TOPS_POLOS_MEN_STYLE_MAP.put("Vests", "203");
		APPAREL_TOPS_POLOS_MEN_STYLE_MAP.put("Kurtas", "204");
	}

	// STYLE HOODIES - APPAREL MEN
	public static final String[] APPAREL_HOODIES_SWEATSHIRTS_MEN_STYLE = {
			"Hoodies", "Sweatshirts" };
	public static final HashMap<String, String> APPAREL_HOODIES_SWEATSHIRTS_MEN_STYLE_MAP;
	static {
		APPAREL_HOODIES_SWEATSHIRTS_MEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_HOODIES_SWEATSHIRTS_MEN_STYLE_MAP.put("Hoodies", "206");
		APPAREL_HOODIES_SWEATSHIRTS_MEN_STYLE_MAP.put("Sweatshirts", "207");

	}

	// STYLE JUMPERS - APPAREL_
	public static final String[] APPAREL_JUMPERS_CARDIGANS_MEN_STYLE = {
			"Jumpers", "Cardigans" };
	public static final HashMap<String, String> APPAREL_JUMPERS_CARDIGANS_MEN_STYLE_MAP;
	static {
		APPAREL_JUMPERS_CARDIGANS_MEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_JUMPERS_CARDIGANS_MEN_STYLE_MAP.put("Jumpers", "209");
		APPAREL_JUMPERS_CARDIGANS_MEN_STYLE_MAP.put("Cardigans", "210");
	}

	// STYLE COATS - APPAREL_
	public static final String[] APPAREL_COATS_JACKETS_MEN_STYLE = { "Coats",
			"Jackets" };
	public static final HashMap<String, String> APPAREL_COATS_JACKETS_MEN_STYLE_MAP;
	static {
		APPAREL_COATS_JACKETS_MEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_COATS_JACKETS_MEN_STYLE_MAP.put("Coats", "212");
		APPAREL_COATS_JACKETS_MEN_STYLE_MAP.put("Jackets", "213");
	}

	// STYLE SUITS - APPAREL_MEN
	public static final String[] APPAREL_SUITS_BLAZERS_MEN_STYLE = { "Suits",
			"Blazers" };
	public static final HashMap<String, String> APPAREL_SUITS_BLAZERS_MEN_STYLE_MAP;
	static {
		APPAREL_SUITS_BLAZERS_MEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_SUITS_BLAZERS_MEN_STYLE_MAP.put("Suits", "215");
		APPAREL_SUITS_BLAZERS_MEN_STYLE_MAP.put("Blazers", "216");
	}

	// STYLE BOTTOM - APPAREL_MEN
	public static final String[] APPAREL_BOTTOMS_MEN_STYLE = { "Trousers",
			"Shorts", "Pyjamas", "Dhotis", "3/4ths", "Cargos", "Jeans" };
	public static final HashMap<String, String> APPAREL_BOTTOMS_MEN_STYLE_MAP;
	static {
		APPAREL_BOTTOMS_MEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_BOTTOMS_MEN_STYLE_MAP.put("Trousers", "218");
		APPAREL_BOTTOMS_MEN_STYLE_MAP.put("Shorts", "219");
		APPAREL_BOTTOMS_MEN_STYLE_MAP.put("Pyjamas", "220");
		APPAREL_BOTTOMS_MEN_STYLE_MAP.put("Dhotis", "221");
		APPAREL_BOTTOMS_MEN_STYLE_MAP.put("3/4ths", "222");
		APPAREL_BOTTOMS_MEN_STYLE_MAP.put("Cargos", "223");
		APPAREL_BOTTOMS_MEN_STYLE_MAP.put("Jeans", "224");
	}

	// STYLE ATHLETIC - APPAREL_MEN
	public static final String[] APPAREL_ATHLETIC_MEN_STYLE = { "Track Suits",
			"Track Pants" };
	public static final HashMap<String, String> APPAREL_ATHLETIC_MEN_STYLE_MAP;
	static {
		APPAREL_ATHLETIC_MEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_ATHLETIC_MEN_STYLE_MAP.put("Track Suits", "235");
		APPAREL_ATHLETIC_MEN_STYLE_MAP.put("Track Pants", "236");
	}

	public static final String[] FOOTWEAR_FOOTWEAR_MEN_STYLE = { "Boots",
			"Sandals", "Shoes", "Slippers", "Formal", "Athletic", "Loafers" };
	public static final HashMap<String, String> FOOTWEAR_FOOTWEAR_MEN_STYLE_MAP;
	static {
		FOOTWEAR_FOOTWEAR_MEN_STYLE_MAP = new HashMap<String, String>();
		FOOTWEAR_FOOTWEAR_MEN_STYLE_MAP.put("Boots", "226");
		FOOTWEAR_FOOTWEAR_MEN_STYLE_MAP.put("Sandals", "227");
		FOOTWEAR_FOOTWEAR_MEN_STYLE_MAP.put("Shoes", "228");
		FOOTWEAR_FOOTWEAR_MEN_STYLE_MAP.put("Slippers", "229");
		FOOTWEAR_FOOTWEAR_MEN_STYLE_MAP.put("Formal", "230");
		FOOTWEAR_FOOTWEAR_MEN_STYLE_MAP.put("Athletic", "231");
		FOOTWEAR_FOOTWEAR_MEN_STYLE_MAP.put("Loafers", "294");
	}
	public static final String[] FOOTWEAR_BAG_MEN_STYLE = { "Backpacks",
			"Duffle Bags", "Laptop Bags", "Luggage Bags", "Messenger Bags",
			"Tote Bags", "Trolley Bags", "Satchels", "Shoulder Bags",
			"Mobile Pouch" };
	public static final HashMap<String, String> FOOTWEAR_BAG_MEN_STYLE_MAP;
	static {
		FOOTWEAR_BAG_MEN_STYLE_MAP = new HashMap<String, String>();
		FOOTWEAR_BAG_MEN_STYLE_MAP.put("Backpacks", "251");
		FOOTWEAR_BAG_MEN_STYLE_MAP.put("Duffle Bags", "252");
		FOOTWEAR_BAG_MEN_STYLE_MAP.put("Laptop Bags", "253");
		FOOTWEAR_BAG_MEN_STYLE_MAP.put("Luggage Bags", "254");
		FOOTWEAR_BAG_MEN_STYLE_MAP.put("Messenger Bags", "255");
		FOOTWEAR_BAG_MEN_STYLE_MAP.put("Tote Bags", "256");
		FOOTWEAR_BAG_MEN_STYLE_MAP.put("Trolley Bags", "257");
		FOOTWEAR_BAG_MEN_STYLE_MAP.put("Satchels", "258");
		FOOTWEAR_BAG_MEN_STYLE_MAP.put("Shoulder Bags", "259");
		FOOTWEAR_BAG_MEN_STYLE_MAP.put("Mobile Pouch", "297");
	}
	public static final String[] FOOTWEAR_ACCESSORIES_MEN_STYLE = { "Belts",
			"Bowties", "Bracelets", "Cufflinks", "Sunglasses", "Neck Chains",
			"Rings", "Scarves", "Ties", "Wallets", "Watches", "Hats", "Caps",
			"Beanies", "Stoles" };
	public static final HashMap<String, String> FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP;
	static {
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP = new HashMap<String, String>();
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Belts", "237");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Bowties", "238");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Bracelets", "239");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Cufflinks", "240");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Sunglasses", "241");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Neck Chains", "242");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Rings", "243");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Scarves", "244");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Ties", "245");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Wallets", "246");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Watches", "247");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Hats", "248");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Caps", "249");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Beanies", "250");
		FOOTWEAR_ACCESSORIES_MEN_STYLE_MAP.put("Stoles", "295");
	}
	public static final String[] WEDDING_TOPS_MEN_STYLE = { "Kurtas",
			"Bandgalas", "Jodhpuris", "Bandis", "Jackets", "Sherwani", "Achkan" };
	public static final HashMap<String, String> WEDDING_TOPS_MEN_STYLE_MAP;
	static {
		WEDDING_TOPS_MEN_STYLE_MAP = new HashMap<String, String>();
		WEDDING_TOPS_MEN_STYLE_MAP.put("Kurtas", "268");
		WEDDING_TOPS_MEN_STYLE_MAP.put("Bandgalas", "269");
		WEDDING_TOPS_MEN_STYLE_MAP.put("Jodhpuris", "270");
		WEDDING_TOPS_MEN_STYLE_MAP.put("Bandis", "271");
		WEDDING_TOPS_MEN_STYLE_MAP.put("Jackets", "273");
		WEDDING_TOPS_MEN_STYLE_MAP.put("Sherwani", "286");
		WEDDING_TOPS_MEN_STYLE_MAP.put("Achkan", "298");
	}
	public static final String[] WEDDING_BOTTOMS_MEN_STYLE = { "Pyjamas",
			"Dhotis", "Trousers", "Churidars", "Patialas", "Jodhpuris" };
	public static final HashMap<String, String> WEDDING_BOTTOMS_MEN_STYLE_MAP;
	static {
		WEDDING_BOTTOMS_MEN_STYLE_MAP = new HashMap<String, String>();
		WEDDING_BOTTOMS_MEN_STYLE_MAP.put("Pyjamas", "274");
		WEDDING_BOTTOMS_MEN_STYLE_MAP.put("Dhotis", "275");
		WEDDING_BOTTOMS_MEN_STYLE_MAP.put("Trousers", "280");
		WEDDING_BOTTOMS_MEN_STYLE_MAP.put("Churidars", "281");
		WEDDING_BOTTOMS_MEN_STYLE_MAP.put("Patialas", "282");
		WEDDING_BOTTOMS_MEN_STYLE_MAP.put("Jodhpuris", "285");
	}
	public static final String[] WEDDING_FULLSETS_MEN_STYLE = { "Tuxedo Set",
			"Suit Set", "Kurta Pyjama", "Indo Western Set", "Sherwani Set",
			"Pathani Suit Set", "Jodhpuri" };
	public static final HashMap<String, String> WEDDING_FULLSETS_MEN_STYLE_MAP;
	static {
		WEDDING_FULLSETS_MEN_STYLE_MAP = new HashMap<String, String>();
		WEDDING_FULLSETS_MEN_STYLE_MAP.put("Tuxedo Set", "263");
		WEDDING_FULLSETS_MEN_STYLE_MAP.put("Suit Set", "264");
		WEDDING_FULLSETS_MEN_STYLE_MAP.put("Kurta Pyjama", "265");
		WEDDING_FULLSETS_MEN_STYLE_MAP.put("Indo Western Set", "266");
		WEDDING_FULLSETS_MEN_STYLE_MAP.put("Sherwani Set", "267");
		WEDDING_FULLSETS_MEN_STYLE_MAP.put("Pathani Suit Set", "272");
		WEDDING_FULLSETS_MEN_STYLE_MAP.put("Jodhpuri", "283");
	}
	public static final String[] WEDDING_FOOTWEAR_MEN_STYLE = { "Formal",
			"Mojaris", "Kolhapuris" };
	public static final HashMap<String, String> WEDDING_FOOTWEAR_MEN_STYLE_MAP;
	static {
		WEDDING_FOOTWEAR_MEN_STYLE_MAP = new HashMap<String, String>();
		WEDDING_FOOTWEAR_MEN_STYLE_MAP.put("Formal", "277");
		WEDDING_FOOTWEAR_MEN_STYLE_MAP.put("Mojaris", "278");
		WEDDING_FOOTWEAR_MEN_STYLE_MAP.put("Kolhapuris", "279");
	}
	public static final String[] WEDDING_HEADWEAR_MEN_STYLE = { "Pagris",
			"Safas", "Sehras", "Dastars", "Top Hats" };
	public static final HashMap<String, String> WEDDING_HEADWEAR_MEN_STYLE_MAP;
	static {
		WEDDING_HEADWEAR_MEN_STYLE_MAP = new HashMap<String, String>();
		WEDDING_HEADWEAR_MEN_STYLE_MAP.put("Pagris", "288");
		WEDDING_HEADWEAR_MEN_STYLE_MAP.put("Safas", "289");
		WEDDING_HEADWEAR_MEN_STYLE_MAP.put("Sehras", "290");
		WEDDING_HEADWEAR_MEN_STYLE_MAP.put("Dastars", "291");
		WEDDING_HEADWEAR_MEN_STYLE_MAP.put("Top Hats", "292");
	}
	
	//APPAREL WOMEN - STYLE
	public static final String[] APPAREL_WOMEN_TYPE = {"Tops", 
		"Dresses",
		"Outer wear",
		"Active wear",
		"Swim",
		"Bottoms",
		"Jeans",
		"Suiting",
		"Saris",
		"Salwar Kameez",
		};
	public static final HashMap<String, String> APPAREL_WOMEN_TYPE_MAP;
	static
    {
		APPAREL_WOMEN_TYPE_MAP = new HashMap<String, String>();
		APPAREL_WOMEN_TYPE_MAP.put("Tops", "5");
		APPAREL_WOMEN_TYPE_MAP.put("Dresses", "6");
		APPAREL_WOMEN_TYPE_MAP.put("Outer wear", "7");
		APPAREL_WOMEN_TYPE_MAP.put("Active wear", "8");
		APPAREL_WOMEN_TYPE_MAP.put("Swim", "9");
		APPAREL_WOMEN_TYPE_MAP.put("Bottoms", "10");
		APPAREL_WOMEN_TYPE_MAP.put("Jeans", "11");
		APPAREL_WOMEN_TYPE_MAP.put("Suiting", "12");
		APPAREL_WOMEN_TYPE_MAP.put("Saris", "126");
		APPAREL_WOMEN_TYPE_MAP.put("Salwar Kameez", "127");
    }
	
	public static final String[] FOOTWEAR_WOMEN_TYPE = {"Footwear", 
		"Bags",
		"Accessories"
	};
	public static final HashMap<String, String> FOOTWEAR_WOMEN_TYPE_MAP;
	static
    {
		FOOTWEAR_WOMEN_TYPE_MAP = new HashMap<String, String>();
		FOOTWEAR_WOMEN_TYPE_MAP.put("Footwear", "14");
		FOOTWEAR_WOMEN_TYPE_MAP.put("Bags", "15");
		FOOTWEAR_WOMEN_TYPE_MAP.put("Accessories", "16");
	}
	public static final String[] WEDDING_WOMEN_TYPE = {"Wedding Dresses", 
		"Wedding Veils",
		"Wedding Jewellery",
		"Wedding Footwear"
	};
	public static final HashMap<String, String> WEDDING_WOMEN_TYPE_MAP;
	static
    {
		WEDDING_WOMEN_TYPE_MAP = new HashMap<String, String>();
		WEDDING_WOMEN_TYPE_MAP.put("Wedding Dresses", "18");
		WEDDING_WOMEN_TYPE_MAP.put("Wedding Veils", "19");
		WEDDING_WOMEN_TYPE_MAP.put("Wedding Jewellery", "159");
		WEDDING_WOMEN_TYPE_MAP.put("Wedding Footwear", "160");
	}
	public static final String[] APPAREL_TOPS_WOMEN_STYLE = {"Blouses", 
		"Button Downs",
		"Night Out",
		"T Shirts",
		"Tank Top and Camis",
		"Sweaters &amp; Pullovers",
		"Sweatshirts &amp; Hoodies",
		"Tunics",
		"Cardigans",
		"Halter Tops",
		"Kurtis &amp; Kurtas"
	};
	public static final HashMap<String, String> APPAREL_TOPS_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_TOPS_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_TOPS_WOMEN_STYLE_MAP.put("Blouses", "20");
		APPAREL_TOPS_WOMEN_STYLE_MAP.put("Button Downs", "21");
		APPAREL_TOPS_WOMEN_STYLE_MAP.put("Night Out", "22");
		APPAREL_TOPS_WOMEN_STYLE_MAP.put("T Shirts", "47");
		APPAREL_TOPS_WOMEN_STYLE_MAP.put("Tank Top and Camis", "48");
		APPAREL_TOPS_WOMEN_STYLE_MAP.put("Sweaters &amp; Pullovers", "49");
		APPAREL_TOPS_WOMEN_STYLE_MAP.put("Sweatshirts &amp; Hoodies", "50");
		APPAREL_TOPS_WOMEN_STYLE_MAP.put("Tunics", "51");
		APPAREL_TOPS_WOMEN_STYLE_MAP.put("Cardigans", "52");
		APPAREL_TOPS_WOMEN_STYLE_MAP.put("Halter Tops", "53");
		APPAREL_TOPS_WOMEN_STYLE_MAP.put("Kurtis &amp; Kurtas", "153");
	}
	public static final String[] APPAREL_DRESSES_WOMEN_STYLE = {"Casual Dresses (Short)", 
		"Casual Dresses (Maxi)",
		"Cocktail Dresses",
		"Formal Dresses",
		"Night Out Dresses",
		"Work/Office Dresses",
		"Rompers &amp; Jumpsuits",
	};
	public static final HashMap<String, String> APPAREL_DRESSES_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_DRESSES_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_DRESSES_WOMEN_STYLE_MAP.put("Casual Dresses (Short)", "23");
		APPAREL_DRESSES_WOMEN_STYLE_MAP.put("Casual Dresses (Maxi)", "24");
		APPAREL_DRESSES_WOMEN_STYLE_MAP.put("Cocktail Dresses", "54");
		APPAREL_DRESSES_WOMEN_STYLE_MAP.put("Formal Dresses", "55");
		APPAREL_DRESSES_WOMEN_STYLE_MAP.put("Night Out Dresses", "56");
		APPAREL_DRESSES_WOMEN_STYLE_MAP.put("Work/Office Dresses", "57");
		APPAREL_DRESSES_WOMEN_STYLE_MAP.put("Rompers &amp; Jumpsuits", "58");
	}
	public static final String[] APPAREL_OUTERWEAR_WOMEN_STYLE = {"Blazers", 
		"Jackets",
		"Coats",
		"Active wear",
		"Vests",
		"Ponchos &amp; Capes"
	};
	public static final HashMap<String, String> APPAREL_OUTERWEAR_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_OUTERWEAR_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_OUTERWEAR_WOMEN_STYLE_MAP.put("Blazers", "25");
		APPAREL_OUTERWEAR_WOMEN_STYLE_MAP.put("Jackets", "26");
		APPAREL_OUTERWEAR_WOMEN_STYLE_MAP.put("Coats", "59");
		APPAREL_OUTERWEAR_WOMEN_STYLE_MAP.put("Active wear", "60");
		APPAREL_OUTERWEAR_WOMEN_STYLE_MAP.put("Vests", "61");
		APPAREL_OUTERWEAR_WOMEN_STYLE_MAP.put("Ponchos &amp; Capes", "62");
	}
	public static final String[] APPAREL_ACTIVEWEAR_WOMEN_STYLE = {"Tops", 
		"Bottoms",
		"Sports Bras",
		"Outer wear",
		"Gear",
		"Sport"
	};
	public static final HashMap<String, String> APPAREL_ACTIVEWEAR_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_ACTIVEWEAR_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_ACTIVEWEAR_WOMEN_STYLE_MAP.put("Tops", "27");
		APPAREL_ACTIVEWEAR_WOMEN_STYLE_MAP.put("Jackets", "28");
		APPAREL_ACTIVEWEAR_WOMEN_STYLE_MAP.put("Sports Bras", "63");
		APPAREL_ACTIVEWEAR_WOMEN_STYLE_MAP.put("Outer wear", "64");
		APPAREL_ACTIVEWEAR_WOMEN_STYLE_MAP.put("Gear", "65");
		APPAREL_ACTIVEWEAR_WOMEN_STYLE_MAP.put("Sport", "66");
	}
	
	public static final String[] APPAREL_SWIM_WOMEN_STYLE = {"Full Bikinis", 
		"Tankinis",
		"One Piece Bathing Suits",
		"Cover-ups &amp; Sarongs",
		"Bikini Tops",
		"Bikini Bottoms"
	};
	public static final HashMap<String, String> APPAREL_SWIM_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_SWIM_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_SWIM_WOMEN_STYLE_MAP.put("Full Bikinis", "29");
		APPAREL_SWIM_WOMEN_STYLE_MAP.put("Tankinis", "30");
		APPAREL_SWIM_WOMEN_STYLE_MAP.put("One Piece Bathing Suits", "67");
		APPAREL_SWIM_WOMEN_STYLE_MAP.put("Cover-ups &amp; Sarongs", "77");
		APPAREL_SWIM_WOMEN_STYLE_MAP.put("Bikini Tops", "78");
		APPAREL_SWIM_WOMEN_STYLE_MAP.put("Bikini Bottoms", "79");
	}
	public static final String[] APPAREL_BOTTOMS_WOMEN_STYLE = {"Pants", 
		"Leggings",
		"Salwars",
		"Churidars",
		"Capris",
		"Shorts",
		"Skirts",
		"Lehengas"
	};
	public static final HashMap<String, String> APPAREL_BOTTOMS_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_BOTTOMS_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_BOTTOMS_WOMEN_STYLE_MAP.put("Pants", "31");
		APPAREL_BOTTOMS_WOMEN_STYLE_MAP.put("Leggings", "32");
		APPAREL_BOTTOMS_WOMEN_STYLE_MAP.put("Salwars", "68");
		APPAREL_BOTTOMS_WOMEN_STYLE_MAP.put("Churidars", "69");
		APPAREL_BOTTOMS_WOMEN_STYLE_MAP.put("Capris", "80");
		APPAREL_BOTTOMS_WOMEN_STYLE_MAP.put("Shorts", "81");
		APPAREL_BOTTOMS_WOMEN_STYLE_MAP.put("Skirts", "82");
		APPAREL_BOTTOMS_WOMEN_STYLE_MAP.put("Lehengas", "154");
	}
	public static final String[] APPAREL_JEANS_WOMEN_STYLE = {"Skinny", 
		"Straight Leg",
		"Boot Cut",
		"Relaxed Fit",
		"Flare Leg",
		"Trouser/Wide Leg",
		"Boyfriend Cut",
		"Capri/Cropped Denim",
		"Cargo Jeans",
		"Denim Shorts",
		"Jeggings"
	};
	public static final HashMap<String, String> APPAREL_JEANS_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_JEANS_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_JEANS_WOMEN_STYLE_MAP.put("Skinny", "33");
		APPAREL_JEANS_WOMEN_STYLE_MAP.put("Straight Leg", "34");
		APPAREL_JEANS_WOMEN_STYLE_MAP.put("Boot Cut", "83");
		APPAREL_JEANS_WOMEN_STYLE_MAP.put("Relaxed Fit", "84");
		APPAREL_JEANS_WOMEN_STYLE_MAP.put("Flare Leg", "85");
		APPAREL_JEANS_WOMEN_STYLE_MAP.put("Trouser/Wide Leg", "86");
		APPAREL_JEANS_WOMEN_STYLE_MAP.put("Boyfriend Cut", "87");
		APPAREL_JEANS_WOMEN_STYLE_MAP.put("Capri/Cropped Denim", "88");
		APPAREL_JEANS_WOMEN_STYLE_MAP.put("Cargo Jeans", "89");
		APPAREL_JEANS_WOMEN_STYLE_MAP.put("Denim Shorts", "90");
		APPAREL_JEANS_WOMEN_STYLE_MAP.put("Jeggings", "91");
	}
	public static final String[] APPAREL_SUITING_WOMEN_STYLE = {"Pants Suits", 
		"Skirt Suits",
		"Shorts Shuits"
	};
	public static final HashMap<String, String> APPAREL_SUITING_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_SUITING_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_SUITING_WOMEN_STYLE_MAP.put("Pants Suits", "35");
		APPAREL_SUITING_WOMEN_STYLE_MAP.put("Skirt Suits", "36");
		APPAREL_BOTTOMS_WOMEN_STYLE_MAP.put("Shorts Shuits", "92");
	}
	/*public static final String[] APPAREL_MATERNITY_WOMEN_STYLE = {"Dresses", 
		"Tops",
		"Denim",
		"Outerwear",
		"Bottoms",
		"Activewear",
		"Swim"
	};
	public static final HashMap<String, String> APPAREL_MATERNITY_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_MATERNITY_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_MATERNITY_WOMEN_STYLE_MAP.put("Dresses", "37");
		APPAREL_MATERNITY_WOMEN_STYLE_MAP.put("Tops", "38");
		APPAREL_MATERNITY_WOMEN_STYLE_MAP.put("Denim", "93");
		APPAREL_MATERNITY_WOMEN_STYLE_MAP.put("Outerwear", "94");
		APPAREL_MATERNITY_WOMEN_STYLE_MAP.put("Bottoms", "95");
		APPAREL_MATERNITY_WOMEN_STYLE_MAP.put("Activewear", "96");
		APPAREL_MATERNITY_WOMEN_STYLE_MAP.put("Swim", "97");
	}*/
	public static final String[] APPAREL_SARIS_WOMEN_STYLE = {"Banarasi", 
		"Silk",
		"Chanderi",
		"Tant",
		"Sambalpuri",
		"Kosa",
		"Nauvari",
		"Chiffon",
		"Georgette",
		"Net",
		"Bandhani"
	};
	public static final HashMap<String, String> APPAREL_SARIS_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_SARIS_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_SARIS_WOMEN_STYLE_MAP.put("Banarasi", "130");
		APPAREL_SARIS_WOMEN_STYLE_MAP.put("Silk", "131");
		APPAREL_SARIS_WOMEN_STYLE_MAP.put("Chanderi", "132");
		APPAREL_SARIS_WOMEN_STYLE_MAP.put("Tant", "133");
		APPAREL_SARIS_WOMEN_STYLE_MAP.put("Sambalpuri", "134");
		APPAREL_SARIS_WOMEN_STYLE_MAP.put("Kosa", "135");
		APPAREL_SARIS_WOMEN_STYLE_MAP.put("Nauvari", "136");
		APPAREL_SARIS_WOMEN_STYLE_MAP.put("Chiffon", "137");
		APPAREL_SARIS_WOMEN_STYLE_MAP.put("Georgette", "138");
		APPAREL_SARIS_WOMEN_STYLE_MAP.put("Net", "139");
		APPAREL_SARIS_WOMEN_STYLE_MAP.put("Bandhani", "140");
	}	
	public static final String[] APPAREL_SALWARKAMEEZ_WOMEN_STYLE = {"Full Set", 
		"Part Set"
	};
	public static final HashMap<String, String> APPAREL_SALWARKAMEEZ_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_SALWARKAMEEZ_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_SALWARKAMEEZ_WOMEN_STYLE_MAP.put("Full Set", "144");
		APPAREL_SALWARKAMEEZ_WOMEN_STYLE_MAP.put("Part Set", "145");
    }
	/*public static final String[] APPAREL_GHAGRACHOLIS_WOMEN_STYLE = {"Full Set", 
		"Part Set"
	};
	public static final HashMap<String, String> APPAREL_GHAGRACHOLIS_WOMEN_STYLE_MAP;
	static
    {
		APPAREL_GHAGRACHOLIS_WOMEN_STYLE_MAP = new HashMap<String, String>();
		APPAREL_GHAGRACHOLIS_WOMEN_STYLE_MAP.put("Full Set", "146");
		APPAREL_GHAGRACHOLIS_WOMEN_STYLE_MAP.put("Part Set", "147");
    }*/
	public static final String[] FOOTWEAR_FOOTWEAR_WOMEN_STYLE = {"Boots &amp; Booties", 
		"Flats",
		"Mules &amp; Clogs",
		"Pumps",
		"Sandals",
		"Athletic",
		"Platforms",
		"Wedges",
		"Formal"
	};
	public static final HashMap<String, String> FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP;
	static
    {
		FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP = new HashMap<String, String>();
		FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP.put("Boots &amp; Booties", "39");
		FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP.put("Flats", "40");
		FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP.put("Mules &amp; Clogs", "70");
		FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP.put("Pumps", "71");
		FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP.put("Sandals", "72");
		FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP.put("Athletic", "73");
		FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP.put("Platforms", "74");
		FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP.put("Wedges", "75");
		FOOTWEAR_FOOTWEAR_WOMEN_STYLE_MAP.put("Formal", "76");
	}
	public static final String[] FOOTWEAR_BAGS_WOMEN_STYLE = {"Cross Body Bags", 
		"Clutches",
		"Hobos",
		"Satchels",
		"Shoulder Bags",
		"Totes",
		"Back packs",
		"Beach Bags",
		"Weekend/Travel Bags",
		"Messenger Bags",
		"Baby &amp; Diaper Bags",
		"Laptop Bags",
		"Wristlets",
		"Baguettes",
		"Mobile Pouch"
	};
	public static final HashMap<String, String> FOOTWEAR_BAGS_WOMEN_STYLE_MAP;
	static
    {
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP = new HashMap<String, String>();
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Cross Body Bags", "41");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Clutches", "42");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Hobos", "98");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Satchels", "99");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Shoulder Bags", "100");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Totes", "101");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Back packs", "102");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Beach Bags", "103");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Weekend/Travel Bags", "104");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Messenger Bags", "105");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Baby &amp; Diaper Bags", "106");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Laptop Bags", "107");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Wristlets", "108");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Baguettes", "109");
		FOOTWEAR_BAGS_WOMEN_STYLE_MAP.put("Mobile Pouch", "296");
	}
	public static final String[] FOOTWEAR_ACCESSORIES_WOMEN_STYLE = {"Jewellery", 
		"Cosmetic Bags",
		"Wallets",
		"Belts",
		"Sunglasses",
		"Hair Accessories",
		"Hats",
		"Scarves &amp; Wraps",
		"Tech Accessories",
		"Watches",
		"Fragrances",
		"Dupattas &amp; Stoles",
		"Shawls &amp; Mufflers"
	};
	public static final HashMap<String, String> FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP;
	static
    {
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP = new HashMap<String, String>();
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Jewellery", "43");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Cosmetic Bags", "110");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Wallets", "111");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Belts", "112");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Sunglasses", "113");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Hair Accessories", "114");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Hats", "115");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Scarves &amp; Wraps", "116");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Tech Accessories", "117");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Watches", "118");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Fragrances", "119");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Dupattas &amp; Stoles", "142");
		FOOTWEAR_ACCESSORIES_WOMEN_STYLE_MAP.put("Shawls &amp; Mufflers", "143");
	}
	public static final String[] WEDDING_WEDDINGDRESSES_WOMEN_STYLE = {"Saris", 
		"Lehengas",
		"Ghagra Cholis",
		"Salwar Kameez",
		"Indo Western",
		"Gowns",
		"Kurta and Sharara"
	};
	public static final HashMap<String, String> WEDDING_WEDDINGDRESSES_WOMEN_STYLE_MAP;
	static
    {
		WEDDING_WEDDINGDRESSES_WOMEN_STYLE_MAP = new HashMap<String, String>();
		WEDDING_WEDDINGDRESSES_WOMEN_STYLE_MAP.put("Saris", "45");
		WEDDING_WEDDINGDRESSES_WOMEN_STYLE_MAP.put("Lehengas", "46");
		WEDDING_WEDDINGDRESSES_WOMEN_STYLE_MAP.put("Ghagra Cholis", "121");
		WEDDING_WEDDINGDRESSES_WOMEN_STYLE_MAP.put("Salwar Kameez", "122");
		WEDDING_WEDDINGDRESSES_WOMEN_STYLE_MAP.put("Indo Western", "123");
		WEDDING_WEDDINGDRESSES_WOMEN_STYLE_MAP.put("Gowns", "124");
		WEDDING_WEDDINGDRESSES_WOMEN_STYLE_MAP.put("Kurta and Sharara", "303");
	}
	public static final String[] WEDDING_WEDDINGVEILS_WOMEN_STYLE = {"Birdcage Veils", 
		"Cap Veils",
		"Mantilla Veils",
		"Gothic Veils"
	};
	public static final HashMap<String, String> WEDDING_WEDDINGVEILS_WOMEN_STYLE_MAP;
	static
    {
		WEDDING_WEDDINGVEILS_WOMEN_STYLE_MAP = new HashMap<String, String>();
		WEDDING_WEDDINGVEILS_WOMEN_STYLE_MAP.put("Birdcage Veils", "155");
		WEDDING_WEDDINGVEILS_WOMEN_STYLE_MAP.put("Cap Veils", "156");
		WEDDING_WEDDINGVEILS_WOMEN_STYLE_MAP.put("Mantilla Veils", "157");
		WEDDING_WEDDINGVEILS_WOMEN_STYLE_MAP.put("Gothic Veils", "158");
	}
	public static final String[] WEDDING_WEDDINGJEWELLERY_WOMEN_STYLE = {"Wedding Necklaces", 
		"Wedding Bracelets",
		"Wedding Rings",
		"Wedding Earrings"
	};
	public static final HashMap<String, String> WEDDING_WEDDINGJEWELLERY_WOMEN_STYLE_MAP;
	static
    {
		WEDDING_WEDDINGJEWELLERY_WOMEN_STYLE_MAP = new HashMap<String, String>();
		WEDDING_WEDDINGJEWELLERY_WOMEN_STYLE_MAP.put("Wedding Necklaces", "165");
		WEDDING_WEDDINGJEWELLERY_WOMEN_STYLE_MAP.put("Wedding Bracelets", "166");
		WEDDING_WEDDINGJEWELLERY_WOMEN_STYLE_MAP.put("Wedding Rings", "167");
		WEDDING_WEDDINGJEWELLERY_WOMEN_STYLE_MAP.put("Wedding Earrings", "168");
	}
	public static final String[] WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE = {"Wedding Boots &amp; Booties", 
		"Wedding Flats",
		"Wedding Mules &amp; Clogs",
		"Wedding Pumps",
		"Wedding Sandals",
		"Wedding Platforms",
		"Wedding Wedges",
		"Wedding Formal"
	};
	public static final HashMap<String, String> WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE_MAP;
	static
    {
		WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE_MAP = new HashMap<String, String>();
		WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE_MAP.put("Wedding Boots &amp; Booties", "169");
		WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE_MAP.put("Wedding Flats", "17O");
		WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE_MAP.put("Wedding Mules &amp; Clogs", "171");
		WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE_MAP.put("Wedding Pumps", "172");
		WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE_MAP.put("Wedding Sandals", "173");
		WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE_MAP.put("Wedding Platforms", "174");
		WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE_MAP.put("Wedding Wedges", "175");
		WEDDING_WEDDINGFOOTWEAR_WOMEN_STYLE_MAP.put("Wedding Formal", "176");
	}
}
