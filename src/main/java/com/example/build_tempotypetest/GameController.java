package com.example.build_tempotypetest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameController implements Initializable {


    private int wordCounter = 0;
    private int first = 1;

    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);


    @FXML
    public Text seconds;
    @FXML
    private Text wordsPerMin;
    @FXML
    private Text accuracy;
    @FXML
    private Text percent;
    @FXML
    private Text programWord;
    @FXML
    private Text secondProgramWord;
    @FXML
    private Text thirdProgramWord;
    @FXML
    private Text firstGoneWord;
    @FXML
    private Text secondGoneWord;

    @FXML
    private TextField userWord;

    @FXML
    private Button playAgain;

    // add words to array list

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToMainthroughGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoUserProfile(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToStats(ActionEvent event) throws IOException {
        gameOver = true;
        root = FXMLLoader.load(getClass().getResource("afterGameStats.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    String CurrentTheme;
    Boolean randomizeList = true;
    Boolean infinity = false;

    ArrayList<String> words = new ArrayList<>();
    public void addToList() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\admin\\Documents\\TurboTypistResources\\localThemes.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String lastLine = "";
        String sCurrentLine = "--";
        while (true)
        {
            try {
                if (!((sCurrentLine = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sCurrentLine);
            lastLine = sCurrentLine;
        }
        CurrentTheme = lastLine;
        System.out.println(CurrentTheme);

        //String[] listOfWords = new String[] {"never", "which", "might", "was", "took", "come", "if", "show", "one", "went", "hard", "can", "often", "kind", "got", "they", "start", "if", "some", "are", "both", "run", "list", "get", "while", "next", "under", "off", "black", "we", "took", "write", "may", "follow", "two", "look", "three", "ask", "both", "war", "little", "last", "might", "is", "without", "begin", "different", "left", "did", "hear", "still", "not", "away", "let", "her", "when", "want", "place", "was", "high", "time", "around", "give", "same", "to", "example", "well", "leave", "about", "play", "leave", "boy", "find", "people", "with", "thing", "year", "through", "your", "mile", "thing", "or", "here", "school", "through", "walk", "would", "find", "life", "or", "said", "great", "grow", "head", "seem", "for", "next", "children", "children", "young", "any", "time", "country", "that", "high", "big", "above", "country", "school", "year", "seem", "may", "big", "home", "left", "so", "now", "very", "man", "give", "life", "talk", "above", "can", "on", "get", "of", "by", "another", "with", "could", "thing", "kind", "story", "life", "had", "sun", "could", "number", "far", "their", "word", "might", "children", "give", "air", "word", "for", "seem", "paper", "off", "young", "above", "where", "take", "help", "was", "which", "those", "house", "kind", "need", "three", "by", "by", "big", "along", "many", "into", "upon", "will", "give", "like", "had", "have", "stop", "think", "walk", "him", "call", "talk", "came", "feet", "is", "add", "face", "black", "study", "until", "car", "air", "at", "face", "hear", "tell", "is", "again", "house", "war", "while", "book", "other", "around", "other", "set", "list", "leave", "new", "three", "list", "left", "world", "our", "up", "here", "made", "now", "still", "story", "paper", "life", "page", "study", "name", "did", "sound", "after", "took", "around", "learn", "place", "must", "until", "would", "children", "much", "fire", "through", "sun", "different", "eye", "open", "than", "state", "story", "see", "know", "our", "land", "who", "man", "home", "word", "but", "of", "much", "country", "came", "father", "get", "might", "you", "house", "around", "new", "those", "we", "look", "open", "answer", "look", "you", "most", "from", "cut", "great", "young", "four", "around", "letter", "play", "and", "more", "last", "learn", "second", "hard", "want", "work", "also", "some", "thought", "off", "people", "talk", "own", "mile", "father", "those", "were", "same", "if", "keep", "end", "saw", "each", "under", "move", "day", "some", "much", "say", "right", "too", "small", "also", "number", "our", "group", "over", "even", "would", "animal", "a", "know", "can", "would", "more", "land", "year", "seem", "why", "write", "who", "tell", "down", "as", "they", "began", "she", "city", "after", "without", "carry", "come", "mother", "keep", "people", "country", "your", "let", "sound", "men", "along", "watch", "men", "white", "are", "live", "ask", "at", "call", "open", "them", "air", "point", "right", "second", "thing", "must", "how", "life", "seem", "were", "those", "off", "always", "without", "on", "let", "big", "own", "children", "read", "country", "if", "up", "oil", "together", "hard", "to", "when", "put", "water", "being", "come", "like", "run", "seem", "came", "house", "each", "spell", "some", "does", "line", "also", "end", "show", "just", "them", "white", "man", "is", "line", "begin", "large", "large", "once", "land", "their", "red", "such", "her", "time", "face", "study", "look", "an", "also", "just", "long", "big", "few", "get", "best", "start", "eye", "she", "tree", "girl", "say", "with", "way", "almost", "word", "what", "have", "away", "where", "when", "men", "with", "his", "new", "near", "face", "live", "people", "it", "war", "find", "at", "above", "our", "year", "or", "long", "both", "move", "want", "plant", "it", "idea", "what", "between", "another", "away", "show", "high", "large", "from", "these", "together", "day", "much", "few", "list", "other", "follow", "another", "few", "is", "change", "family", "through", "said", "take", "but", "word", "mother", "high", "come", "white", "few", "big", "want", "man", "young", "go", "as", "if", "tree", "take", "few", "mile", "list", "word", "change", "run", "number", "seem", "watch", "miss", "make", "group", "back", "part", "day", "turn", "war", "her", "kind", "his", "make", "made", "too", "some"};


        String[] hardList = new String[] {"aback","abaft","abandoned","abashed","aberrant","abhorrent","abiding","abject","ablaze","able","abnormal","aboard","aboriginal","abortive","abounding","abrasive","abrupt","absent","absorbed","absorbing","abstracted","absurd","abundant","abusive","accept","acceptable","accessible","accidental","account","accurate","achiever","acid","acidic","acoustic","acoustics","acrid","act","action","activity","actor","actually","ad hoc","adamant","adaptable","add","addicted","addition","adhesive","adjoining","adjustment","admire","admit","adorable","adventurous","advertisement","advice","advise","afford","afraid","aftermath","afternoon","afterthought","aggressive","agonizing","agree","agreeable","agreement","ahead","air","airplane","airport","ajar","alarm","alcoholic","alert","alike","alive","alleged","allow","alluring","aloof","amazing","ambiguous","ambitious","amount","amuck","amuse","amused","amusement","amusing","analyze","ancient","anger","angle","angry","animal","animated","announce","annoy","annoyed","annoying","answer","ants","anxious","apathetic","apologise","apparatus","apparel","appear","applaud","appliance","appreciate","approval","approve","aquatic","arch","argue","argument","arithmetic","arm","army","aromatic","arrange","arrest","arrive","arrogant","art","ashamed","ask","aspiring","assorted","astonishing","attach","attack","attempt","attend","attract","attraction","attractive","aunt","auspicious","authority","automatic","available","average","avoid","awake","aware","awesome","awful","axiomatic","babies","baby","back","bad","badge","bag","bait","bake","balance","ball","ban","bang","barbarous","bare","base","baseball","bashful","basin","basket","basketball","bat","bath","bathe","battle","bawdy","bead","beam","bear","beautiful","bed","bedroom","beds","bee","beef","befitting","beg","beginner","behave","behavior","belief","believe","bell","belligerent","bells","belong","beneficial","bent","berry","berserk","best","better","bewildered","big","bike","bikes","billowy","bird","birds","birth","birthday","bit","bite","bite-sized","bitter","bizarre","black","black-and-white","blade","bleach","bless","blind","blink","blood","bloody","blot","blow","blue","blue-eyed","blush","blushing","board","boast","boat","boil","boiling","bolt","bomb","bone","book","books","boorish","boot","border","bore","bored","boring","borrow","bottle","bounce","bouncy","boundary","boundless","bow","box","boy","brainy","brake","branch","brash","brass","brave","brawny","breakable","breath","breathe","breezy","brick","bridge","brief","bright","broad","broken","brother","brown","bruise","brush","bubble","bucket","building","bulb","bump","bumpy","burly","burn","burst","bury","bushes","business","bustling","busy","butter","button","buzz","cabbage","cable","cactus","cagey","cake","cakes","calculate","calculating","calculator","calendar","call","callous","calm","camera","camp","can","cannon","canvas","cap","capable","capricious","caption","car","card","care","careful","careless","caring","carpenter","carriage","carry","cars","cart","carve","cast","cat","cats","cattle","cause","cautious","cave","ceaseless","celery","cellar","cemetery","cent","certain","chalk","challenge","chance","change","changeable","channel","charge","charming","chase","cheap","cheat","check","cheer","cheerful","cheese","chemical","cherries","cherry","chess","chew","chicken","chickens","chief","childlike","children","chilly","chin","chivalrous","choke","chop","chubby","chunky","church","circle","claim","clam","clammy","clap","class","classy","clean","clear","clever","clip","cloistered","close","closed","cloth","cloudy","clover","club","clumsy","cluttered","coach","coal","coast","coat","cobweb","coherent","coil","cold","collar","collect","color","colorful","colossal","colour","comb","combative","comfortable","command","committee","common","communicate","company","compare","comparison","compete","competition","complain","complete","complex","concentrate","concern","concerned","condemned","condition","confess","confuse","confused","connect","connection","conscious","consider","consist","contain","continue","control","cooing","cook","cool","cooperative","coordinated","copper","copy","corn","correct","cough","count","country","courageous","cover","cow","cowardly","cows","crabby","crack","cracker","crash","crate","craven","crawl","crayon","crazy","cream","creator","creature","credit","creepy","crib","crime","crook","crooked","cross","crow","crowd","crowded","crown","cruel","crush","cry","cub","cuddly","cultured","cumbersome","cup","cure","curious","curl","curly","current","curtain","curve","curved","curvy","cushion","cut","cute","cycle","cynical","dad","daffy","daily","dam","damage","damaged","damaging","damp","dance","dangerous","dapper","dare","dark","dashing","daughter","day","dazzling","dead","deadpan","deafening","dear","death","debonair","debt","decay","deceive","decide","decision","decisive","decorate","decorous","deep","deeply","deer","defeated","defective","defiant","degree","delay","delicate","delicious","delight","delightful","delirious","deliver","demonic","depend","dependent","depressed","deranged","describe","descriptive","desert","deserted","deserve","design","desire","desk","destroy","destruction","detail","detailed","detect","determined","develop","development","devilish","didactic","different","difficult","digestion","diligent","dime","dinner","dinosaurs","direction","direful","dirt","dirty","disagree","disagreeable","disappear","disapprove","disarm","disastrous","discover","discovery","discreet","discussion","disgusted","disgusting","disillusioned","dislike","dispensable","distance","distinct","distribution","disturbed","divergent","divide","division","dizzy","dock","doctor","dog","dogs","doll","dolls","domineering","donkey","door","double","doubt","doubtful","downtown","drab","draconian","drag","drain","dramatic","drawer","dream","dreary","dress","drink","drip","driving","drop","drown","drum","drunk","dry","duck","ducks","dull","dust","dusty","dynamic","dysfunctional","eager","ear","early","earn","earsplitting","earth","earthquake","earthy","easy","eatable","economic","edge","educate","educated","education","effect","efficacious","efficient","egg","eggnog","eggs","eight","elastic","elated","elbow","elderly","electric","elegant","elfin","elite","embarrass","embarrassed","eminent","employ","empty","enchanted","enchanting","encourage","encouraging","end","endurable","energetic","engine","enjoy","enormous","enter","entertain","entertaining","enthusiastic","envious","equable","equal","erect","erratic","error","escape","ethereal","evanescent","evasive","even","event","examine","example","excellent","exchange","excite","excited","exciting","exclusive","excuse","exercise","exist","existence","exotic","expand","expansion","expect","expensive","experience","expert","explain","explode","extend","extra-large","extra-small","exuberant","exultant","eye","eyes","fabulous","face","fact","fade","faded","fail","faint","fair","fairies","faithful","fall","fallacious","false","familiar","famous","fanatical","fancy","fang","fantastic","far","far-flung","farm","fascinated","fast","fasten","fat","faulty","fax","fear","fearful","fearless","feeble","feeling","feigned","female","fence","fertile","festive","fetch","few","field","fierce","file","fill","film","filthy","fine","finger","finicky","fire","fireman","first","fish","fit","five","fix","fixed","flag","flagrant","flaky","flame","flap","flash","flashy","flat","flavor","flawless","flesh","flight","flimsy","flippant","float","flock","flood","floor","flow","flower","flowers","flowery","fluffy","fluttering","fly","foamy","fog","fold","follow","food","fool","foolish","foot","force","foregoing","forgetful","fork","form","fortunate","found","four","fowl","fragile","frail","frame","frantic","free","freezing","frequent","fresh","fretful","friction","friend","friendly","friends","frighten","frightened","frightening","frog","frogs","front","fruit","fry","fuel","full","fumbling","functional","funny","furniture","furry","furtive","future","futuristic","fuzzy","gabby","gainful","gamy","gaping","garrulous","gate","gather","gaudy","gaze","geese","general","gentle","ghost","giant","giants","giddy","gifted","gigantic","giraffe","girl","girls","glamorous","glass","gleaming","glib","glistening","glorious","glossy","glove","glow","glue","godly","gold","good","goofy","gorgeous","government","governor","grab","graceful","grade","grain","grandfather","grandiose","grandmother","grape","grass","grate","grateful","gratis","gray","grease","greasy","great","greedy","green","greet","grey","grieving","grin","grip","groan","groovy","grotesque","grouchy","ground","group","growth","grubby","gruesome","grumpy","guarantee","guard","guarded","guess","guide","guiltless","guitar","gullible","gun","gusty","guttural","habitual","hair","haircut","half","hall","hallowed","halting","hammer","hand","handle","hands","handsome","handsomely","handy","hang","hanging","hapless","happen","happy","harass","harbor","hard","hard-to-find","harm","harmonious","harmony","harsh","hat","hate","hateful","haunt","head","heady","heal","health","healthy","heap","heartbreaking","heat","heavenly","heavy","hellish","help","helpful","helpless","hesitant","hideous","high","high-pitched","highfalutin","hilarious","hill","hissing","historical","history","hobbies","hole","holiday","holistic","hollow","home","homeless","homely","honey","honorable","hook","hop","hope","horn","horrible","horse","horses","hose","hospitable","hospital","hot","hour","house","houses","hover","hug","huge","hulking","hum","humdrum","humor","humorous","hungry","hunt","hurried","hurry","hurt","hushed","husky","hydrant","hypnotic","hysterical","ice","icicle","icky","icy","idea","identify","idiotic","ignorant","ignore","ill","ill-fated","ill-informed","illegal","illustrious","imaginary","imagine","immense","imminent","impartial","imperfect","impolite","important","imported","impossible","impress","improve","impulse","incandescent","include","income","incompetent","inconclusive","increase","incredible","industrious","industry","inexpensive","infamous","influence","inform","inject","injure","ink","innate","innocent","inquisitive","insect","insidious","instinctive","instruct","instrument","insurance","intelligent","intend","interest","interesting","interfere","internal","interrupt","introduce","invent","invention","invincible","invite","irate","iron","irritate","irritating","island","itch","itchy","jaded","jagged","jail","jam","jar","jazzy","jealous","jeans","jelly","jellyfish","jewel","jittery","jobless","jog","join","joke","jolly","joyous","judge","judicious","juggle","juice","juicy","jumbled","jump","jumpy","juvenile","kaput","keen","kettle","key","kick","kill","kind","kindhearted","kindly","kiss","kittens","kitty","knee","kneel","knife","knit","knock","knot","knotty","knowing","knowledge","knowledgeable","known","label","labored","laborer","lace","lackadaisical","lacking","ladybug","lake","lame","lamentable","lamp","land","language","languid","large","last","late","laugh","laughable","launch","lavish","lazy","lean","learn","learned","leather","left","leg","legal","legs","lethal","letter","letters","lettuce","level","lewd","library","license","lick","lie","light","lighten","like","likeable","limit","limping","line","linen","lip","liquid","list","listen","literate","little","live","lively","living","load","loaf","lock","locket","lonely","long","long-term","longing","look","loose","lopsided","loss","loud","loutish","love","lovely","loving","low","lowly","lucky","ludicrous","lumber","lumpy","lunch","lunchroom","lush","luxuriant","lying","lyrical","macabre","machine","macho","maddening","madly","magenta","magic","magical","magnificent","maid","mailbox","majestic","makeshift","male","malicious","mammoth","man","manage","maniacal","many","marble","march","mark","marked","market","married","marry","marvelous","mask","mass","massive","match","mate","material","materialistic","matter","mature","meal","mean","measly","measure","meat","meaty","meddle","medical","meek","meeting","mellow","melodic","melt","melted","memorize","memory","men","mend","merciful","mere","mess up","messy","metal","mice","middle","mighty","military","milk","milky","mind","mindless","mine","miniature","minister","minor","mint","minute","miscreant","miss","mist","misty","mitten","mix","mixed","moan","moaning","modern","moldy","mom","momentous","money","monkey","month","moon","moor","morning","mother","motion","motionless","mountain","mountainous","mourn","mouth","move","muddle","muddled","mug","multiply","mundane","murder","murky","muscle","mushy","mute","mysterious","nail","naive","name","nappy","narrow","nasty","nation","natural","naughty","nauseating","near","neat","nebulous","necessary","neck","need","needle","needless","needy","neighborly","nerve","nervous","nest","new","next","nice","nifty","night","nimble","nine","nippy","nod","noise","noiseless","noisy","nonchalant","nondescript","nonstop","normal","north","nose","nostalgic","nosy","note","notebook","notice","noxious","null","number","numberless","numerous","nut","nutritious","nutty","oafish","oatmeal","obedient","obeisant","obese","obey","object","obnoxious","obscene","obsequious","observant","observation","observe","obsolete","obtain","obtainable","occur","ocean","oceanic","odd","offbeat","offend","offer","office","oil","old","old-fashioned","omniscient","one","onerous","open","opposite","optimal","orange","oranges","order","ordinary","organic","ossified","outgoing","outrageous","outstanding","oval","oven","overconfident","overflow","overjoyed","overrated","overt","overwrought","owe","own","pack","paddle","page","pail","painful","painstaking","paint","pale","paltry","pan","pancake","panicky","panoramic","paper","parallel","parcel","parched","park","parsimonious","part","partner","party","pass","passenger","past","paste","pastoral","pat","pathetic","pause","payment","peace","peaceful","pear","peck","pedal","peel","peep","pen","pencil","penitent","perfect","perform","periodic","permissible","permit","perpetual","person","pest","pet","petite","pets","phobic","phone","physical","picayune","pick","pickle","picture","pie","pies","pig","pigs","pin","pinch","pine","pink","pipe","piquant","pizzas","place","placid","plain","plan","plane","planes","plant","plantation","plants","plastic","plate","plausible","play","playground","pleasant","please","pleasure","plot","plough","plucky","plug","pocket","point","pointless","poised","poison","poke","polish","polite","political","pollution","poor","pop","popcorn","porter","position","possess","possessive","possible","post","pot","potato","pour","powder","power","powerful","practice","pray","preach","precede","precious","prefer","premium","prepare","present","preserve","press","pretend","pretty","prevent","previous","price","pricey","prick","prickly","print","private","probable","produce","productive","profit","profuse","program","promise","property","prose","protect","protective","protest","proud","provide","psychedelic","psychotic","public","puffy","pull","pump","pumped","punch","puncture","punish","punishment","puny","purple","purpose","purring","push","pushy","puzzled","puzzling","quack","quaint","quarrelsome","quarter","quartz","queen","question","questionable","queue","quick","quickest","quicksand","quiet","quill","quilt","quince","quirky","quiver","quixotic","quizzical","rabbit","rabbits","rabid","race","racial","radiate","ragged","rail","railway","rain","rainstorm","rainy","raise","rake","rambunctious","rampant","range","rapid","rare","raspy","rat","rate","ratty","ray","reach","reaction","reading","ready","real","realize","reason","rebel","receipt","receive","receptive","recess","recognise","recondite","record","red","reduce","redundant","reflect","reflective","refuse","regret","regular","reign","reject","rejoice","relation","relax","release","relieved","religion","rely","remain","remarkable","remember","remind","reminiscent","remove","repair","repeat","replace","reply","report","representative","reproduce","repulsive","request","rescue","resolute","resonant","respect","responsible","rest","retire","return","reward","rhetorical","rhyme","rhythm","rice","rich","riddle","rifle","right","righteous","rightful","rigid","ring","rings","rinse","ripe","risk","ritzy","river","road","roasted","rob","robin","robust","rock","rod","roll","romantic","roof","room","roomy","root","rose","rot","rotten","rough","round","route","royal","rub","ruddy","rude","ruin","rule","run","rural","rush","rustic","ruthless","sable","sack","sad","safe","sail","salt","salty","same","sand","sassy","satisfy","satisfying","save","savory","saw","scale","scandalous","scarce","scare","scarecrow","scared","scarf","scary","scatter","scattered","scene","scent","school","science","scientific","scintillating","scissors","scold","scorch","scrape","scratch","scrawny","scream","screeching","screw","scribble","scrub","sea","seal","search","seashore","seat","second","second-hand","secret","secretary","secretive","sedate","seed","seemly","selection","selective","self","selfish","sense","separate","serious","servant","serve","settle","shade","shaggy","shake","shaky","shallow","shame","shape","share","sharp","shave","sheep","sheet","shelf","shelter","shiny","ship","shirt","shiver","shivering","shock","shocking","shoe","shoes","shop","short","show","shrill","shrug","shut","shy","sick","side","sidewalk","sigh","sign","signal","silent","silk","silky","silly","silver","simple","simplistic","sin","sincere","sink","sip","sister","sisters","six","size","skate","ski","skillful","skin","skinny","skip","skirt","sky","slap","slave","sleep","sleepy","sleet","slim","slimy","slip","slippery","slope","sloppy","slow","small","smart","smash","smell","smelly","smile","smiling","smoggy","smoke","smooth","snail","snails","snake","snakes","snatch","sneaky","sneeze","sniff","snobbish","snore","snotty","snow","soak","soap","society","sock","soda","sofa","soft","soggy","solid","somber","son","song","songs","soothe","sophisticated","sordid","sore","sort","sound","soup","sour","space","spade","spare","spark","sparkle","sparkling","special","spectacular","spell","spicy","spiders","spiffy","spiky","spill","spiritual","spiteful","splendid","spoil","sponge","spooky","spoon","spot","spotless","spotted","spotty","spray","spring","sprout","spurious","spy","squalid","square","squash","squeak","squeal","squealing","squeamish","squeeze","squirrel","stage","stain","staking","stale","stamp","standing","star","stare","start","statement","station","statuesque","stay","steadfast","steady","steam","steel","steep","steer","stem","step","stereotyped","stew","stick","sticks","sticky","stiff","stimulating","stingy","stir","stitch","stocking","stomach","stone","stop","store","stormy","story","stove","straight","strange","stranger","strap","straw","stream","street","strengthen","stretch","string","strip","striped","stroke","strong","structure","stuff","stupendous","stupid","sturdy","subdued","subsequent","substance","substantial","subtract","succeed","successful","succinct","suck","sudden","suffer","sugar","suggest","suggestion","suit","sulky","summer","sun","super","superb","superficial","supply","support","suppose","supreme","surprise","surround","suspect","suspend","swanky","sweater","sweet","sweltering","swift","swim","swing","switch","symptomatic","synonymous","system","table","taboo","tacit","tacky","tail","talented","talk","tall","tame","tan","tangible","tangy","tank","tap","tart","taste","tasteful","tasteless","tasty","tawdry","tax","teaching","team","tearful","tease","tedious","teeny","teeny-tiny","teeth","telephone","telling","temper","temporary","tempt","ten","tendency","tender","tense","tent","tenuous","terrible","terrific","terrify","territory","test","tested","testy","texture","thank","thankful","thaw","theory","therapeutic","thick","thin","thing","things","thinkable","third","thirsty","thought","thoughtful","thoughtless","thread","threatening","three","thrill","throat","throne","thumb","thunder","thundering","tick","ticket","tickle","tidy","tie","tiger","tight","tightfisted","time","tin","tiny","tip","tire","tired","tiresome","title","toad","toe","toes","tomatoes","tongue","tooth","toothbrush","toothpaste","toothsome","top","torpid","touch","tough","tour","tow","towering","town","toy","toys","trace","trade","trail","train","trains","tramp","tranquil","transport","trap","trashy","travel","tray","treat","treatment","tree","trees","tremble","tremendous","trick","tricky","trip","trite","trot","trouble","troubled","trousers","truck","trucks","truculent","true","trust","truthful","try","tub","tug","tumble","turkey","turn","twig","twist","two","type","typical","ubiquitous","ugliest","ugly","ultra","umbrella","unable","unaccountable","unadvised","unarmed","unbecoming","unbiased","uncle","uncovered","understood","underwear","undesirable","undress","unequal","unequaled","uneven","unfasten","unhealthy","uninterested","unique","unit","unite","unkempt","unknown","unlock","unnatural","unpack","unruly","unsightly","unsuitable","untidy","unused","unusual","unwieldy","unwritten","upbeat","uppity","upset","uptight","use","used","useful","useless","utopian","utter","uttermost","vacation","vacuous","vagabond","vague","valuable","value","van","vanish","various","vase","vast","vegetable","veil","vein","vengeful","venomous","verdant","verse","versed","vessel","vest","victorious","view","vigorous","violent","violet","visit","visitor","vivacious","voice","voiceless","volatile","volcano","volleyball","voracious","voyage","vulgar","wacky","waggish","wail","wait","waiting","wakeful","walk","wall","wander","wandering","want","wanting","war","warlike","warm","warn","wary","wash","waste","wasteful","watch","water","watery","wave","waves","wax","way","weak","wealth","wealthy","weary","weather","week","weigh","weight","welcome","well-groomed","well-made","well-off","well-to-do","wet","wheel","whimsical","whine","whip","whirl","whisper","whispering","whistle","white","whole","wholesale","wicked","wide","wide-eyed","wiggly","wild","wilderness","willing","wind","window","windy","wine","wing","wink","winter","wipe","wire","wiry","wise","wish","wistful","witty","wobble","woebegone","woman","womanly","women","wonder","wonderful","wood","wooden","wool","woozy","word","work","workable","worm","worried","worry","worthless","wound","wrap","wrathful","wreck","wren","wrench","wrestle","wretched","wriggle","wrist","writer","writing","wrong","wry","x-ray","yak","yam","yard","yarn","yawn","year","yell","yellow","yielding","yoke","young","youthful","yummy","zany","zealous","zebra","zephyr","zesty","zinc","zip","zipper","zippy","zonked","zoo","zoom"};

        String[] easyList = new String[] {"never", "which", "might", "was", "took", "come", "if", "show", "one", "went", "hard", "can", "often", "kind", "got", "they", "start", "if", "some", "are", "both", "run", "list", "get", "while", "next", "under", "off", "black", "we", "took", "write", "may", "follow", "two", "look", "three", "ask", "both", "war", "little", "last", "might", "is", "without", "begin", "different", "left", "did", "hear", "still", "not", "away", "let", "her", "when", "want", "place", "was", "high", "time", "around", "give", "same", "to", "example", "well", "leave", "about", "play", "leave", "boy", "find", "people", "with", "thing", "year", "through", "your", "mile", "thing", "or", "here", "school", "through", "walk", "would", "find", "life", "or", "said", "great", "grow", "head", "seem", "for", "next", "children", "children", "young", "any", "time", "country", "that", "high", "big", "above", "country", "school", "year", "seem", "may", "big", "home", "left", "so", "now", "very", "man", "give", "life", "talk", "above", "can", "on", "get", "of", "by", "another", "with", "could", "thing", "kind", "story", "life", "had", "sun", "could", "number", "far", "their", "word", "might", "children", "give", "air", "word", "for", "seem", "paper", "off", "young", "above", "where", "take", "help", "was", "which", "those", "house", "kind", "need", "three", "by", "by", "big", "along", "many", "into", "upon", "will", "give", "like", "had", "have", "stop", "think", "walk", "him", "call", "talk", "came", "feet", "is", "add", "face", "black", "study", "until", "car", "air", "at", "face", "hear", "tell", "is", "again", "house", "war", "while", "book", "other", "around", "other", "set", "list", "leave", "new", "three", "list", "left", "world", "our", "up", "here", "made", "now", "still", "story", "paper", "life", "page", "study", "name", "did", "sound", "after", "took", "around", "learn", "place", "must", "until", "would", "children", "much", "fire", "through", "sun", "different", "eye", "open", "than", "state", "story", "see", "know", "our", "land", "who", "man", "home", "word", "but", "of", "much", "country", "came", "father", "get", "might", "you", "house", "around", "new", "those", "we", "look", "open", "answer", "look", "you", "most", "from", "cut", "great", "young", "four", "around", "letter", "play", "and", "more", "last", "learn", "second", "hard", "want", "work", "also", "some", "thought", "off", "people", "talk", "own", "mile", "father", "those", "were", "same", "if", "keep", "end", "saw", "each", "under", "move", "day", "some", "much", "say", "right", "too", "small", "also", "number", "our", "group", "over", "even", "would", "animal", "a", "know", "can", "would", "more", "land", "year", "seem", "why", "write", "who", "tell", "down", "as", "they", "began", "she", "city", "after", "without", "carry", "come", "mother", "keep", "people", "country", "your", "let", "sound", "men", "along", "watch", "men", "white", "are", "live", "ask", "at", "call", "open", "them", "air", "point", "right", "second", "thing", "must", "how", "life", "seem", "were", "those", "off", "always", "without", "on", "let", "big", "own", "children", "read", "country", "if", "up", "oil", "together", "hard", "to", "when", "put", "water", "being", "come", "like", "run", "seem", "came", "house", "each", "spell", "some", "does", "line", "also", "end", "show", "just", "them", "white", "man", "is", "line", "begin", "large", "large", "once", "land", "their", "red", "such", "her", "time", "face", "study", "look", "an", "also", "just", "long", "big", "few", "get", "best", "start", "eye", "she", "tree", "girl", "say", "with", "way", "almost", "word", "what", "have", "away", "where", "when", "men", "with", "his", "new", "near", "face", "live", "people", "it", "war", "find", "at", "above", "our", "year", "or", "long", "both", "move", "want", "plant", "it", "idea", "what", "between", "another", "away", "show", "high", "large", "from", "these", "together", "day", "much", "few", "list", "other", "follow", "another", "few", "is", "change", "family", "through", "said", "take", "but", "word", "mother", "high", "come", "white", "few", "big", "want", "man", "young", "go", "as", "if", "tree", "take", "few", "mile", "list", "word", "change", "run", "number", "seem", "watch", "miss", "make", "group", "back", "part", "day", "turn", "war", "her", "kind", "his", "make", "made", "too", "some"};

        String[] story1List = new String[] {"-", "-","When", "I", "was", "a", "small", "child", "my", "grandparents", "would", "take", "me", "blackberry", "picking.", "It", "was", "usually", "late", "August", "when", "the", "blackberries", "had", "full", "ripened.", "Grandad", "would", "drive", "us", "is", "in", "his", "old", "van.", "Despite", "not", "being", "comfortable", "or", "particularly", "safe,", "Grandad’s", "vans", "had", "a", "character", "you", "would", "not", "find", "in", "a", "sleek", "new", "car", "complete", "with", "the", "latest", "innovations", "and", "a", "silent", "engine.", "Being", "seven", "or", "eight", "at", "the", "time,", "I", "always", "enjoyed", "a", "trip", "as", "we", "bounced", "along", "to", "our", "destination.", "My", "grandparents", "always", "chose", "the", "same", "spot.", "Wild", "blackberry", "bushes", "stretched", "along", "the", "roadside", "as", "far", "as", "the", "eye", "could", "see", "in", "both", "directions.", "The", "road", "overlooked", "a", "small", "pitch", "and", "putt", "course.", "On", "such", "sunny", "summer", "days", "it", "was", "always", "full.", "Golfers", "ambled", "sedately", "from", "hole", "to", "hole", "and", "the", "crack", "of", "metal", "striking", "ball", "was", "a", "constant", "accompaniment.", "Several", "hours", "of", "picking", "berries", "ensued.", "Nana", "warned", "me", "not", "to", "eat", "any", "until", "they", "had", "all", "been", "washed", "but", "turned", "a", "knowing", "blind", "eye", "while", "I", "gorged", "anyway.", "I", "also", "helped", "myself", "to", "the", "occasional", "unripe", "red", "berry", "as", "I", "had", "a", "particular", "taste", "for", "anything", "bitter.", "The", "fully", "immature", "green", "berries", "proved", "a", "step", "too", "far", "for", "even", "my", "pallet", "and", "were", "merely", "unpleasant.", "When", "at", "last", "we", "were", "finished", "the", "bright", "scenery", "had", "turned", "to", "lengthy", "shadows", "and", "the", "afternoon", "had", "elapsed", "into", "evening.", "Grandad", "hauled", "a", "bin", "bag", "half", "full", "of", "berries", "back", "to", "the", "van.", "Juice", "bled", "slowly", "onto", "the", "ground.", "Nana", "would", "later", "make", "apple", "and", "blackberry", "tarts", "and", "fill", "several", "jars", "with", "jam.", "When", "I", "reached", "the", "van", "my", "stomach", "hurt", "from", "too", "much", "fruit.", "My", "hands", "stung", "from", "constant", "thorn", "pricks", "and", "were", "stained", "dark", "purple.", "I", "always", "enjoyed", "those", "days."};
        String[] story2List = new String[] {"-","-","It", "was", "a", "totally", "worse,", "devastating", "day", "for", "him.", "It", "was", "the", "day", "his", "end", "semester", "results", "came.The", "dilly-dally", "moments", "he", "spent", "with", "his", "friends", "flashed", "through", "his", "heart.", "He", "used", "to", "be", "a", "diligent", "guy", "until", "this", "semester.", "Now,", "he", "joined", "the", "elite", "group", "of", "arrear", "guys.", "All", "of", "his", "ephemeral", "friends", "managed", "to", "clear", "this", "semester.", "They", "all", "had", "the", "same", "lazy,", "dilettantish", "attitude", "even", "now.", "They", "didn’t", "even", "cared", "to", "ask", "about", "his", "results.He", "scolded", "himself", "for", "prioritizing", "his", "time", "for", "these", "perfidious", "friends", "over", "his", "parents,", "his", "true", "friends.His", "parents", "didn’t", "scold", "him.", "They", "supported", "him.", "Tried", "to", "motivate", "him,", "embrace", "him.", "They", "believed", "in", "him.", "He", "used", "to", "be", "a", "dumb", "kid", "in", "school", "days.", "It", "was", "the", "unceasing", "motivation", "and", "caring", "of", "his", "parents", "that", "got", "him", "into", "a", "premier", "college.Now", "he", "started", "introspect.He", "started", "asking", "himself,", "what", "can", "I", "do", "to", "get", "rid", "of", "this", "heartache?He", "remembered", "Rumi’s", "wise", "Lines:“It’s", "your", "Road.", "Everyone", "can", "walk", "with", "you.", "But,", "no", "one", "can", "walk", "for", "you”He", "said", "to", "himself", "“Firstly,", "I", "need", "to", "change", "my", "friend", "circle.", "Even", "my", "parents", "can", "only", "support", "me.", "The", "change", "needs", "to", "begin", "with", "myself.", "It’s", "my", "Road.", "And", "I’m", "going", "to", "lay", "it", "slowly", "but", "beautifully"};
        String[] story3List = new String[] {"-","-","The", "shepherd", "and", "losing", "sheeps.", "Ms.", "Joan,", "an", "elderly", "woman,", "who", "has", "fifty", "sheeps,", "and", "her", "shepherd", "Jack,", "takes", "them", "every", "morning", "to", "grazing", "in", "the", "nearby", "valley.", "Everything", "went", "as", "usual", "until", "one", "day", "the", "evening.", "Then", "something", "unexpected", "happened.", "Before", "going", "home", "he", "heard", "a", "strange", "metallic", "noise", "at", "the", "end", "of", "the", "herd.", "A", "dark", "container", "opened", "up", "by", "itself,", "headed", "towards", "the", "back", "end", "of", "the", "herd,", "closed", "suddenly", "and", "disappeared", "under", "the", "ground.", "Sheep", "fled", "frightened.", "He", "got", "scared", "and", "led", "the", "herd", "quickly", "to", "the", "house.", "After", "counting", "the", "sheeps,", "Jack", "found", "out", "that", "one", "was", "missing.", "He", "told", "her", "employer.", "She", "managed", "to", "thrust", "out", "the", "words:", "Be", "careful", "or", "no", "more", "job", "for", "you", "the", "evening,", "after", "Jack", "came", "back", "home,", "again", "one", "sheep", "was", "missing.", "Jack", "lost", "his", "job", "and", "Ms.", "Joan", "called", "Police", "regarding", "the", "missing", "sheeps.", "Jack", "was", "still", "at", "the", "scene", "and", "was", "questioned.", "He", "said", "that", "he", "know", "anything", "about", "that.", "Several", "police", "officers", "with", "trained", "dogs", "entered", "the", "valley", "to", "search", "for", "a", "clue", "about", "the", "missing", "sheeps.", "They", "were", "there", "for", "several", "hours", "but", "nothing", "suspicious", "happened.", "One", "of", "the", "dogs", "suddenly", "started", "barking", "nearby.", "Police", "officers", "went", "there", "and", "began", "to", "dig.", "Not", "long", "after", "they", "began", "to", "dig", "they", "found", "a", "lid.", "One", "of", "them", "opened", "it", "and", "they", "went", "inside", "into", "a", "big", "and", "long", "tunnel", "with", "lights", "on.", "They", "found", "another", "door.", "They", "opened", "it", "and", "they", "saw", "a", "professor", "like", "a", "scientist", "working", "with", "a", "high-tech", "device", "containing", "a", "big", "screen", "with", "flashing", "lights", "on", "and", "off,", "electronic", "signals", "and", "diagrams", "moving", "horizontally", "and", "vertically", "like", "sinusoids", "and", "the", "like"};
        String[] story4List = new String[] {"-","-","Somebody", "once", "told", "me", "the", "world", "is", "gonna", "roll", "me", "I", "ain\'t", "the", "sharpest", "tool", "in", "the", "shed", "She", "was", "looking", "kind", "of", "dumb", "with", "her", "finger", "and", "her", "thumb", "In", "the", "shape", "of", "an", "L", "on", "her", "forehead", "Well", "the", "years", "start", "coming", "and", "they", "don'\t", "stop", "coming", "Fed", "to", "the", "rules", "and", "I", "hit", "the", "ground", "running", "Didn'\t", "make", "sense", "not", "to", "live", "for", "fun", "Your", "brain", "gets", "smart", "but", "your", "head", "gets", "dumb", "So", "much", "to", "do,", "so", "much", "to", "see", "So", "know", "if", "you", "never", "shine", "if", "you", "glow", "Hey", "now,", "you\'re", "an", "all-star,", "get", "your", "game", "on,", "go", "play", "Hey", "now,", "you\'re", "a", "rock", "star,", "get", "the", "show", "on,", "get", "paid", "And", "all", "that", "glitters", "is", "gold", "Only", "shooting", "stars", "break", "the", "mold", "bundled", "up", "now,", "wait", "ging", "getting", "warm", "so", "you", "might", "as", "well", "swim", "My", "the", "way", "I", "like", "it", "and", "an", "all-star,", "get", "your", "game", "on,", "go", "play", "Hey", "now,", "you\'re", "a", "rock", "star,", "get", "the", "show", "on,", "get", "paid", "All", "that", "glitters", "is", "gold", "Only", "shooting", "stars", "break", "the", "mold", "Hey", "now,", "you're", "an", "all-star", "get", "your", "game", "on,", "go", "play", "Hey", "place", "I", "said,", "what", "a", "concept", "I", "could", "use", "a", "lit", "stop", "coming", "Fed", "to", "the", "rules", "and", "I", "hit", "the", "ground", "running", "Didn\'t", "make", "sense", "not", "to", "live", "for", "fun", "Your", "brain", "gets", "smart", "but", "your", "head", "gets", "dumb", "So", "much", "to", "do,", "so", "much", "to", "see", "So", "what\'s", "never", "know", "if", "you", "don\'t", "never", "shine"};
        String[][] Stories = {story1List, story2List, story3List, story4List};

        String[] infinityList = new String[] {"never", "which", "might", "was", "took", "come", "if", "show", "one", "went", "hard", "can", "often", "kind", "got", "they", "start", "if", "some", "are", "both", "run", "list", "get", "while", "next", "under", "off", "black", "we", "took", "write", "may", "follow", "two", "look", "three", "ask", "both", "war", "little", "last", "might", "is", "without", "begin", "different", "left", "did", "hear", "still", "not", "away", "let", "her", "when", "want", "place", "was", "high", "time", "around", "give", "same", "to", "example", "well", "leave", "about", "play", "leave", "boy", "find", "people", "with", "thing", "year", "through", "your", "mile", "thing", "or", "here", "school", "through", "walk", "would", "find", "life", "or", "said", "great", "grow", "head", "seem", "for", "next", "children", "children", "young", "any", "time", "country", "that", "high", "big", "above", "country", "school", "year", "seem", "may", "big", "home", "left", "so", "now", "very", "man", "give", "life", "talk", "above", "can", "on", "get", "of", "by", "another", "with", "could", "thing", "kind", "story", "life", "had", "sun", "could", "number", "far", "their", "word", "might", "children", "give", "air", "word", "for", "seem", "paper", "off", "young", "above", "where", "take", "help", "was", "which", "those", "house", "kind", "need", "three", "by", "by", "big", "along", "many", "into", "upon", "will", "give", "like", "had", "have", "stop", "think", "walk", "him", "call", "talk", "came", "feet", "is", "add", "face", "black", "study", "until", "car", "air", "at", "face", "hear", "tell", "is", "again", "house", "war", "while", "book", "other", "around", "other", "set", "list", "leave", "new", "three", "list", "left", "world", "our", "up", "here", "made", "now", "still", "story", "paper", "life", "page", "study", "name", "did", "sound", "after", "took", "around", "learn", "place", "must", "until", "would", "children", "much", "fire", "through", "sun", "different", "eye", "open", "than", "state", "story", "see", "know", "our", "land", "who", "man", "home", "word", "but", "of", "much", "country", "came", "father", "get", "might", "you", "house", "around", "new", "those", "we", "look", "open", "answer", "look", "you", "most", "from", "cut", "great", "young", "four", "around", "letter", "play", "and", "more", "last", "learn", "second", "hard", "want", "work", "also", "some", "thought", "off", "people", "talk", "own", "mile", "father", "those", "were", "same", "if", "keep", "end", "saw", "each", "under", "move", "day", "some", "much", "say", "right", "too", "small", "also", "number", "our", "group", "over", "even", "would", "animal", "a", "know", "can", "would", "more", "land", "year", "seem", "why", "write", "who", "tell", "down", "as", "they", "began", "she", "city", "after", "without", "carry", "come", "mother", "keep", "people", "country", "your", "let", "sound", "men", "along", "watch", "men", "white", "are", "live", "ask", "at", "call", "open", "them", "air", "point", "right", "second", "thing", "must", "how", "life", "seem", "were", "those", "off", "always", "without", "on", "let", "big", "own", "children", "read", "country", "if", "up", "oil", "together", "hard", "to", "when", "put", "water", "being", "come", "like", "run", "seem", "came", "house", "each", "spell", "some", "does", "line", "also", "end", "show", "just", "them", "white", "man", "is", "line", "begin", "large", "large", "once", "land", "their", "red", "such", "her", "time", "face", "study", "look", "an", "also", "just", "long", "big", "few", "get", "best", "start", "eye", "she", "tree", "girl", "say", "with", "way", "almost", "word", "what", "have", "away", "where", "when", "men", "with", "his", "new", "near", "face", "live", "people", "it", "war", "find", "at", "above", "our", "year", "or", "long", "both", "move", "want", "plant", "it", "idea", "what", "between", "another", "away", "show", "high", "large", "from", "these", "together", "day", "much", "few", "list", "other", "follow", "another", "few", "is", "change", "family", "through", "said", "take", "but", "word", "mother", "high", "come", "white", "few", "big", "want", "man", "young", "go", "as", "if", "tree", "take", "few", "mile", "list", "word", "change", "run", "number", "seem", "watch", "miss", "make", "group", "back", "part", "day", "turn", "war", "her", "kind", "his", "make", "made", "too", "some"};

        String[] listOfWords;

        if (CurrentTheme.equals("Normal")){
            listOfWords = easyList.clone();
            System.out.println("Normal Difficulty");

        }
        else if (CurrentTheme.equals("Hard")) {
            listOfWords = hardList.clone();
            System.out.println("Hard Difficulty");
        }
        else if(CurrentTheme.equals("Story Mode")){
            randomizeList = false;
            Random generator = new Random();
            int index = generator.nextInt(Stories.length);
            listOfWords = Stories[index].clone();

            System.out.println("Story Mode");
        }
        else if(CurrentTheme.equals("Infinity")){
            infinity = true;
            listOfWords = easyList.clone();
        }
        else{
            listOfWords = easyList.clone();
            System.out.println("Normal(unchosen) Difficulty");
        }

        int size = listOfWords.length;

        for (int word = 0; word < size; word++)
        {
            words.add(listOfWords[word]);
        }

    }


    public void WriteFile(String strFile, String strData)
    {
        try( BufferedWriter bf = new BufferedWriter(new FileWriter(strFile, true)))
        {
            bf.write(strData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int timerValue;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SettingsController settingsCLA = new SettingsController();
        seconds.setText(String.valueOf(timerSetting));
        addToList();
        if (randomizeList == true) {
            Collections.shuffle(words);
        }
        randomizeList = true;
        secondGoneWord.setText(words.get(wordCounter));
        firstGoneWord.setText(words.get(wordCounter+1));
        programWord.setText(words.get(wordCounter+2));
        secondProgramWord.setText(words.get(wordCounter+3));
        thirdProgramWord.setText(words.get(wordCounter+4));

        wordCounter++;
    }

    public int getTimer(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\admin\\Documents\\TurboTypistResources\\localTimers.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String lastLine = "";
        String sCurrentLine = "--";
        while (true)
        {
            try {
                if (!((sCurrentLine = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            lastLine = sCurrentLine;
        }
        timerValue = Integer.parseInt(lastLine);
        return timerValue;
    }

    int timerSetting = getTimer();

    int multiplyingFactor = (60/timerSetting);


    Boolean gameOver = false;
    private int timer = timerSetting;
    Runnable r = new Runnable() {
        @Override
        public void run() {
            if(infinity){
                seconds.setText("∞");
            }
            else
            {
                if (timer > -1) {
                    seconds.setText(String.valueOf(timer));
                    timer -= 1;
                }


                else {
                    if (timer == -1) {
                        userWord.setDisable(true);
                        userWord.setText("Press Next");
                        playAgain.setVisible(true);
                        gameOver = true;
                        int CorrectWPM = (multiplyingFactor * counter);
                        String data = "-" + String.valueOf(CorrectWPM) + "-" + accuracy.getText();

                        try {
                            // Creates a FileWriter
                            FileWriter file = new FileWriter("C:\\Users\\admin\\Documents\\TurboTypistResources\\LocalScores.txt", true);

                            // Creates a BufferedWriter
                            BufferedWriter output = new BufferedWriter(file);

                            // Writes the string to the file
                            output.write(data);

                            // Closes the writer
                            output.close();
                        } catch (Exception e) {
                            e.getStackTrace();
                        }
                    }

                    if (timer == -4) {


                        executor.shutdown();
                    }

                    timer--;
                }

            }
        }
    };



    private int countAll = 0;
    private int counter = 0;
    String numInCounter;
    ArrayList<String> WPMS = new ArrayList<>();

    public void startGame(KeyEvent ke) throws IOException {
        if (infinity == false){
            playAgain.setVisible(false);
        }
        // only gets called once
        if (first == 1) {
            first = 0;
            ProfileController cla = new ProfileController();
            System.out.println(cla.getValue());
            executor.scheduleAtFixedRate(r, 0, 1, TimeUnit.SECONDS);
        }

        if (ke.getCode().equals(KeyCode.ENTER) || ke.getCode().equals(KeyCode.SPACE)) {

            String getUserWord = userWord.getText();
            String correctWord = programWord.getText();
            countAll++;
            getUserWord = getUserWord.replaceAll("\\s","");

            // if correct
            if (getUserWord.equals(correctWord)) {
                counter++;
                wordsPerMin.setText(String.valueOf(counter));
                numInCounter = String.valueOf(counter);

                WPMS.add(numInCounter);

            }

            userWord.setText("");
            percent.setText("%");
            accuracy.setText(String.valueOf(Math.round(((counter*1.0/countAll)*100))));
            secondGoneWord.setText(words.get(wordCounter));
            firstGoneWord.setText(words.get(wordCounter+1));
            programWord.setText(words.get(wordCounter+2));
            secondProgramWord.setText(words.get(wordCounter+3));
            thirdProgramWord.setText(words.get(wordCounter+4));
            wordCounter++;
        }


    }


    String giveWPM;
    String number = "10";
    public String getNumber() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\Documents\\TurboTypistResources\\LocalScores.txt"));

        String lastLine = "";
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null)
        {
            lastLine = sCurrentLine;
        }
        String[] ArrayLine = lastLine.split("-");
        giveWPM = ArrayLine[1];

        /*
        System.out.println(String.valueOf(gameOver));
        System.out.println(WPMS);
        if (gameOver == true){
            giveWPM = WPMS.get(-2);

        }
        else{
            giveWPM = " ";
        }
        */

        return this.giveWPM;
    }

}


