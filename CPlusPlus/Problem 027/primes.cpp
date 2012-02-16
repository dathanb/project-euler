#include "primes.h"
#include <cstdlib>

// all Carmichael numbers that will fit in a 32-bit word
int carmichaels[] = {561, 1105, 1729, 2465, 2821, 6601, 8911, 10585, 
15841, 29341, 41041, 46657, 52633, 62745, 63973, 75361, 101101, 115921, 
126217, 162401, 172081, 188461, 252601, 278545, 294409, 314821, 334153, 
340561, 399001, 410041, 449065, 488881, 512461, 530881, 552721, 656601, 
658801, 670033, 748657, 825265, 838201, 852841, 997633, 1024651, 1033669, 
1050985, 1082809, 1152271, 1193221, 1461241, 1569457, 1615681, 1773289, 
1857241, 1909001, 2100901, 2113921, 2433601, 2455921, 2508013, 2531845, 
2628073, 2704801, 3057601, 3146221, 3224065, 3581761, 3664585, 3828001, 
4335241, 4463641, 4767841, 4903921, 4909177, 5031181, 5049001, 5148001, 
5310721, 5444489, 5481451, 5632705, 5968873, 6049681, 6054985, 6189121, 
6313681, 6733693, 6840001, 6868261, 7207201, 7519441, 7995169, 8134561, 
8341201, 8355841, 8719309, 8719921, 8830801, 8927101, 9439201, 9494101, 
9582145, 9585541, 9613297, 9890881, 10024561, 10267951, 10402561, 10606681, 
10837321, 10877581, 11119105, 11205601, 11921001, 11972017, 12261061, 
12262321, 12490201, 12945745, 13187665, 13696033, 13992265, 14469841, 
14676481, 14913991, 15247621, 15403285, 15829633, 15888313, 16046641, 
16778881, 17098369, 17236801, 17316001, 17586361, 17812081, 18162001, 
18307381, 18900973, 19384289, 19683001, 20964961, 21584305, 22665505, 
23382529, 25603201, 26280073, 26474581, 26719701, 26921089, 26932081, 
27062101, 27336673, 27402481, 28787185, 29020321, 29111881, 31146661, 
31405501, 31692805, 32914441, 33302401, 33596641, 34196401, 34657141, 
34901461, 35571601, 35703361, 36121345, 36765901, 37167361, 37280881, 
37354465, 37964809, 38151361, 38624041, 38637361, 39353665, 40160737, 
40280065, 40430401, 40622401, 40917241, 41298985, 41341321, 41471521, 
42490801, 43286881, 43331401, 43584481, 43620409, 44238481, 45318561, 
45877861, 45890209, 46483633, 47006785, 48321001, 48628801, 49333201, 
50201089, 53245921, 53711113, 54767881, 55462177, 56052361, 58489201, 
60112885, 60957361, 62756641, 64377991, 64774081, 65037817, 65241793, 
67371265, 67653433, 67902031, 67994641, 68154001, 69331969, 70561921, 
72108421, 72286501, 74165065, 75151441, 75681541, 75765313, 76595761, 
77826001, 78091201, 78120001, 79411201, 79624621, 80282161, 80927821, 
81638401, 81926461, 82929001, 83099521, 83966401, 84311569, 84350561, 
84417985, 87318001, 88689601, 90698401, 92625121, 93030145, 93614521, 
93869665, 94536001, 96895441, 99036001, 99830641, 99861985, 100427041, 
101649241, 101957401, 102090781, 104404861, 104569501, 104852881, 105117481, 
105309289, 105869401, 106041937, 107714881, 109393201, 109577161, 111291181, 
114910489, 115039081, 115542505, 116682721, 118901521, 119327041, 120981601, 
121247281, 122785741, 124630273, 127664461, 128697361, 129255841, 129762001, 
130032865, 130497361, 132511681, 133205761, 133344793, 133800661, 134809921, 
134857801, 135556345, 136625941, 139592101, 139952671, 140241361, 144218341, 
145124785, 146843929, 150846961, 151530401, 151813201, 153589801, 153927961, 
157731841, 158404141, 158864833, 159492061, 161035057, 161242705, 161913961, 
163954561, 167979421, 168659569, 169057801, 169570801, 170947105, 171454321, 
171679561, 172290241, 172430401, 172947529, 173085121, 174352641, 175997185, 
176659201, 178451857, 178482151, 178837201, 180115489, 181154701, 182356993, 
184353001, 186393481, 186782401, 187188001, 188516329, 188689501, 189941761, 
193708801, 193910977, 194120389, 194675041, 196358977, 200753281, 206955841, 
208969201, 212027401, 213835861, 214850881, 214852609, 216821881, 221884001, 
225745345, 226509361, 227752993, 228842209, 230630401, 230996949, 231194965, 
237597361, 238244041, 238527745, 241242001, 242641153, 246446929, 247095361, 
250200721, 252141121, 255160621, 256828321, 257495641, 258634741, 266003101, 
270857521, 271481329, 271794601, 273769921, 274569601, 275283401, 277241401, 
278152381, 279377281, 280067761, 280761481, 288120421, 289766701, 289860481, 
291848401, 292244833, 292776121, 295643089, 295826581, 296559361, 299736181, 
300614161, 301704985, 302751505, 306871201, 311388337, 318266641, 321197185, 
321602401, 325546585, 328573477, 329769721, 333065305, 333229141, 334783585, 
338740417, 346808881, 348612265, 354938221, 357277921, 357380101, 358940737, 
360067201, 362569201, 364590721, 366532321, 366652201, 367804801, 367939585, 
368113411, 382304161, 382536001, 390489121, 392099401, 393122521, 393513121, 
393716701, 395044651, 395136505, 396262945, 399906001, 403043257, 403317421, 
405739681, 413058601, 413138881, 413631505, 416964241, 417241045, 419520241, 
426821473, 429553345, 434330401, 434932961, 438359041, 440306461, 440707345, 
455106601, 458368201, 461502097, 461854261, 462199681, 471441001, 471905281, 
473847121, 477726145, 481239361, 483006889, 484662529, 490099681, 490503601, 
492559141, 496050841, 499310197, 503758801, 507726901, 509033161, 510825601, 
511338241, 516684961, 517937581, 518117041, 518706721, 527761081, 529782121, 
530443201, 532758241, 533860309, 540066241, 542497201, 544101481, 545363281, 
545570641, 547652161, 548871961, 549117205, 549333121, 549538081, 551672221, 
552894301, 555465601, 556199281, 556450777, 557160241, 557795161, 558570961, 
558977761, 561481921, 561777121, 564651361, 568227241, 569332177, 573896881, 
577240273, 579606301, 580565233, 590754385, 593234929, 595405201, 597717121, 
600892993, 602074585, 602426161, 602593441, 606057985, 609865201, 611397865, 
612347905, 612816751, 616463809, 618068881, 620169409, 621101185, 625060801, 
625482001, 629692801, 631071001, 633639097, 638959321, 642708001, 652969351, 
656187001, 662086041, 672389641, 683032801, 683379841, 684106401, 686059921, 
689880801, 697906561, 698548201, 702683101, 703995733, 704934361, 705101761, 
707926801, 710382401, 710541481, 711374401, 713588401, 717164449, 721244161, 
722923201, 727083001, 739444021, 743404663, 744866305, 745864945, 746706961, 
752102401, 759472561, 765245881, 771043201, 775368901, 775866001, 776176261, 
781347841, 784966297, 790020001, 790623289, 794937601, 798770161, 804978721, 
809702401, 809883361, 814056001, 822531841, 824389441, 824405041, 829678141, 
832060801, 833608321, 834244501, 834720601, 836515681, 839275921, 841340521, 
842202361, 843704401, 847491361, 849064321, 851703301, 851934601, 852729121, 
854197345, 855734401, 860056705, 863984881, 867800701, 868234081, 876850801, 
882796321, 885336481, 888700681, 891706861, 897880321, 902645857, 914801665, 
918661501, 928482241, 930745621, 931694401, 934784929, 935794081, 939947009, 
940123801, 941056273, 945959365, 947993761, 954732853, 955134181, 957044881, 
958735681, 958762729, 958970545, 962442001, 962500561, 963163201, 963168193, 
968553181, 968915521, 975303121, 977737321, 977892241, 981567505, 981789337, 
985052881, 986088961, 990893569, 993420289, 993905641, 1001152801, 
1018928485, 1027334881, 1030401901, 1031750401, 1035608041, 1038165961, 
1055384929, 1070659201, 1072570801, 1074363265, 1079556193, 1090842145, 
1093916341, 1100674561, 1103145121, 1125038377, 1131222841, 1132988545, 
1134044821, 1136739745, 1138049137, 1140441121, 1150270849, 1152793621, 
1162202581, 1163659861, 1177195201, 1177800481, 1180398961, 1183104001, 
1189238401, 1190790721, 1193229577, 1194866101, 1198650961, 1200456577, 
1200778753, 1206057601, 1207252621, 1210178305, 1213619761, 1214703721, 
1216631521, 1223475841, 1227220801, 1227280681, 1232469001, 1251295501, 
1251992281, 1254318481, 1256855041, 1257102001, 1260332137, 1264145401, 
1268604001, 1269295201, 1271325841, 1295577361, 1299963601, 1309440001, 
1312114945, 1312332001, 1316958721, 1317828601, 1318126321, 1321983937, 
1330655041, 1332521065, 1337805505, 1348964401, 1349671681, 1362132541, 
1376844481, 1378483393, 1382114881, 1384157161, 1394746081, 1394942473, 
1404111241, 1404228421, 1407548341, 1410833281, 1419339691, 1420379065, 
1422477001, 1423668961, 1428966001, 1439328001, 1439492041, 1441316269, 
1442761201, 1445084173, 1452767521, 1481619601, 1483199641, 1490078305, 
1490522545, 1504651681, 1505432881, 1507746241, 1515785041, 1520467201, 
1521835381, 1528936501, 1529544961, 1534274841, 1540454761, 1545387481, 
1571503801, 1573132561, 1574601601, 1576826161, 1583582113, 1588247851, 
1592668441, 1597009393, 1597821121, 1615335085, 1618206745, 1626167341, 
1632785701, 1641323905, 1646426881, 1648076041, 1657700353, 1659935761, 
1672719217, 1674309385, 1676203201, 1676641681, 1678569121, 1685266561, 
1688214529, 1688639041, 1689411601, 1690230241, 1696572001, 1698623641, 
1699279441, 1701016801, 1705470481, 1708549501, 1726372441, 1746692641, 
1750412161, 1752710401, 1760460481, 1769031901, 1772267281, 1773486001, 
1776450565, 1778382541, 1784291041, 1784975941, 1785507361, 1795216501, 
1801558201, 1803278401, 1817067169, 1825568641, 1828377001, 1831048561, 
1833328621, 1836304561, 1841034961, 1845871105, 1846817281, 1848112761, 
1848681121, 1849811041, 1854001513, 1855100017, 1858395529, 1879480513, 
1887933601, 1894344001, 1896961801, 1899525601, 1913016001, 1916729101, 
1918052065, 1919767681, 1932608161, 1942608529, 1943951041, 1949646601, 
1950276565, 1954174465, 1955324449, 1958102641, 1962804565, 1976295241, 
1984089601, 1988071801, 1992841201, 1999004365, 2000436751, 2023528501, 
2029554241, 2048443501, 2048751901, 2049293401, 2064236401, 2064373921, 
2067887557, 2073560401, 2080544005, 2097317377, 2101170097, 2105594401, 
2107535221, 2111416021, 2111488561, 2117725921, 2126689501, 2140538401, 
2140699681, 2159003281, 2170282969, 2176838049, 2178944461, 2199700321, 
2199931651, 2201169601, 2212935985, 2215407601, 2216430721, 2217951073, 
2223876601, 2224519921, 2230305949, 2232385345, 2239622113, 2244932281, 
2246916001, 2258118721, 2265650401, 2272748401, 2278677961, 2295209281, 
2301745249, 2302419601, 2309027281, 2313774001, 2320224481, 2320690177, 
2322648901, 2323147201, 2332627249, 2335640077, 2339165521, 2342644921, 
2353639681, 2359686241, 2361232477, 2367379201, 2377166401, 2391137281, 
2396357041, 2407376665, 2414829781, 2430556381, 2436691321, 2438403661, 
2443829641, 2444950561, 2456536681, 2457411265, 2467813621, 2470348441, 
2470894273, 2479305985, 2480343553, 2489462641, 2494465921, 2494621585, 
2497638781, 2509860961, 2510085721, 2519819281, 2523947041, 2527812001, 
2529410281, 2539024741, 2544590161, 2547621973, 2560104001, 2560600351, 
2561945401, 2564889601, 2573686441, 2574243721, 2575260241, 2586927553, 
2588653081, 2597928961, 2598933481, 2601144001, 2602378721, 2605557781, 
2607162961, 2607237361, 2616662881, 2617181281, 2630374741, 2642025673, 
2657502001, 2665141921, 2677147201, 2685422593, 2690867401, 2693939401, 
2702470861, 2709611521, 2723859001, 2733494401, 2735309521, 2766172501, 
2766901501, 2770560241, 2776874941, 2787998641, 2797002901, 2801124001, 
2806205689, 2811315361, 2815304401, 2832480001, 2833846561, 2842912381, 
2858298301, 2867755969, 2942952481, 2943556201, 2965085641, 2998467901, 
3001561441, 3007991701, 3022354401, 3024774901, 3025708561, 3030758401, 
3034203361, 3035837161, 3044238121, 3044970001, 3068534701, 3069196417, 
3072080089, 3072094201, 3077802001, 3078386641, 3086434561, 3088134721, 
3090578401, 3102234751, 3104207821, 3105567361, 3112974481, 3119101921, 
3138302401, 3159422785, 3159939601, 3164207761, 3180288385, 3180632833, 
3188744065, 3190894201, 3193414093, 3203895601, 3215031751, 3222053185, 
3232450585, 3240392401, 3245477761, 3246238801, 3248891101, 3249390145, 
3263564305, 3264820001, 3270933121, 3277595665, 3281736601, 3284630713, 
3307322305, 3313196881, 3313744561, 3314111761, 3319323601, 3328437481, 
3345878017, 3347570941, 3348463105, 3353809537, 3378014641, 3380740301, 
3411338491, 3413656441, 3429457921, 3438721441, 3441837421, 3480174001, 
3504570301, 3508507801, 3521441665, 3534510001, 3555636481, 3574014445, 
3575798785, 3576804001, 3600918181, 3618244081, 3630291841, 3637405045, 
3682471321, 3697952401, 3711456001, 3712280041, 3713287801, 3715938721, 
3722793481, 3727589761, 3754483201, 3767865601, 3776698801, 3787491457, 
3799111681, 3800513761, 3801823441, 3805181281, 3832646221, 3834444901, 
3835537861, 3858853681, 3863326897, 3880251649, 3891338101, 3892568065, 
3901730401, 3907357441, 3922752121, 3928256641, 3951813601, 3981047941, 
3998554561, 4015029061, 4030864201, 4034969401, 4059151489, 4065133501, 
4077957961, 4115677501, 4127050621, 4134273793, 4138747921, 4146685921, 
4160472121, 4162880401, 4167038161, 4169092201, 4169867689, 4189909501, 
4199202001, 4199529601, 4199932801, 4202009461, 4210922233, 4212413569, 
4215885697, 4216799521, 4277982241};

int is_carmichael(int n)
{
	// just do a binary search in carmichaels to try to find n
	int upper = sizeof(carmichaels)-1;
	int lower = 0;
	int p = sizeof(carmichaels)/2;

	while (upper != lower)
	{
		if (carmichaels[p] == n)
		{
			return true;
		}
		else if (carmichaels[p] > n)
		{
			upper = (upper + lower)/2;
		}
		else
		{
			lower = (lower+upper)/2;
		}
	}
	return false;
}

// is_prime
int is_prime(int n)
{
	if (n < 1)
	{
		return false;// only integers greater than 2 can be prime
	}
	else if (n == 2)
	{
		// the first prime is known  and this implementation of the fermat primality test barfs on 2  so let's just go ahead and return true here
		return true;
	}
	else
	{
		// first, try the fermat test
		return fermat_primality_test(n);
	}

	// TODO: implement other primality tests
}

// TODO: fix this to work with smaller numbers
/*
From wikipedia:
Fermat's little theorem states that if p is prime and 1 <= a < p then
a^(p-1)%p==1
If we want to test if p is prime  then we can pick random a's in the interval and see if the equality holds. 
If the equality does not hold for a value of a  then p is composite. If the equality does hold for many values 
of a  then we can say that p is probably prime  or a pseudoprime.
*/
int fermat_primality_test(int n, int certainty)
{


	for (int iteration = 0; iteration < certainty; ++iteration)
	{
		// pick a random a:1< a < n  then test a^(n-1) mod n to see if it's 1
		int a = (rand() % (n - 2))+ 2;
		long long temp = 1;
		for (int i=1; i<n; ++i)
		{
			temp = (temp * a) % n;
		}
		
		if (temp != 1)
		{
			// a is a Fermat witness for n
			return false;
		}
	}

	// before we return true, let's further verify that n is not a Carmichael number
	if (is_carmichael(n))
		return false;

	// to the best of our knowledge  it's prime
	return true;
}
