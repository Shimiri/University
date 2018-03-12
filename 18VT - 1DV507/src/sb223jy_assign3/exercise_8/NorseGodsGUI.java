package sb223jy_assign3.exercise_8;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.util.HashMap;

public class NorseGodsGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text title = new Text("Norse Gods and other beings");
        title.setFont(Font.font("Verdana", FontWeight.BOLD, 24));

        Text name = new Text();
        name.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        Text race = new Text();
        race.setFont(Font.font("Verdana", FontPosture.ITALIC, 15));
        Text desc = new Text();

        TextFlow tf = new TextFlow(name, race, desc);
        tf.setTextAlignment(TextAlignment.LEFT);
        tf.setPrefSize(300, 400);

        ScrollPane sp = new ScrollPane();
        sp.setFitToWidth(true);
        sp.setContent(tf);

        HashMap<String, NorseGod> map = createHashMap();
        ListView<String> list = new ListView<>();
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            NorseGod god = map.get(observable.getValue());
            name.setText(god.getName() + "\n");
            race.setText(god.getRace() + "\n\n");
            desc.setText(god.getDesc());
        });

        ObservableList<String> items = FXCollections.observableArrayList("Odin", "Thor", "Loki", "Baldur", "Freyr",
                "Freyja", "Heimdallr", "Tyr", "Bragi");
        list.setPrefWidth(150);
        list.setItems(items);

        BorderPane layout = new BorderPane();
        layout.setTop(title);
        layout.setLeft(list);
        layout.setCenter(sp);

        BorderPane.setMargin(title, new Insets(5, 5, 5, 5));
        BorderPane.setMargin(list, new Insets(0, 5, 5, 5));
        BorderPane.setMargin(tf, new Insets(0, 5, 5, 0));

        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }

    private HashMap<String, NorseGod> createHashMap() {
        HashMap<String, NorseGod> map = new HashMap<>();
        map.put("Odin",
                new NorseGod("Odin", "Asir",
                        "In Norse mythology, Odin (Old Norse: Odinn) is the chief of the Asir who rules over Asgard as king. The son of Borr and the giantess (jötunn) Bestla, Odin is the god of wisdom, poetry, war, death, divination, and magic. Known as the All-Father, Odin is often accompanied by the two ravens Huginn and Muninn, along with his twin wolves Geri and Freki, who would devour those who would present false information to or otherwise lie to Odin. Father of Thor and husband to Frigg, Odin rides into battle atop his trusted steed, the eight-legged Sleipnir, wielding the mighty spear Gungnir, which, fashioned by the dwarves known as the Sons of Ivaldi, is said to never miss its target. Odin resides in the palace of Valaskjálf, roofed with pure silver. Therein lies the great throne of Hliðskjálf, which, when seated upon, allows the All-Father to see all that which transpires throughout the Nine Realms. A defining trait of Odin is his being one-eyed, a result of him having sacrificed his right eye to drink from the Well of Urðr, which granted him an incomprehensible amount of knowledge of the universe. Odin himself often receives counsel from the severed head of the being Mimir."));
        map.put("Thor",
                new NorseGod("Thor", "Asir",
                        "Thor (Old Norse: Þórr) is the god of thunder and lightning in Norse mythology, associated with strength, storms, hallowing and fertility. The son of Odin All-Father and Jörð (the personification of the Earth), Thor is physically the strongest of the Æsir. The brother of Baldr and Höðr, he is the eldest of Odin's sons and husband of the goddess Sif, known for her golden hair. Described as being fierce eyed, with red hair and a full beard, Thor was quick to anger and had an enormous appetite. The champion of Asgard, Thor was said to protect both it and Midgard from the likes of the jǫtnar, a race of beings native to Jötunheimr. He was known in Old English as Þunor (Thunor) and in Old High German as Donar (runic þonar ᚦᛟᚾᚨᚱ), all stemming from the Proto-Germanic term *Þunraz, meaning \"thunder\""));
        map.put("Loki",
                new NorseGod("Loki", "Asir",
                        "In Norse mythology, Loki, god of trickery (Anglicized (/ˈloʊki/)), Loptr, or Hveðrungr is a god or jötunn (or both).  By the jötunn Angrboða, Loki is the father of Hel, the wolf Fenrir, and the world serpent Jörmungandr. By his wife Sigyn, Loki is the father of Narfi and/or Nari. By the stallion Svaðilfari, Loki is the mother—giving birth in the form of a mare (female horse) —to the eight-legged horse Sleipnir. In addition, Loki is referred to be the father of Váli in the Prose Edda. Besides, Loki is a shape shifter and in separate incidents he appears in the form of a salmon, a mare, a fly, and possibly an elderly woman named Þökk (Old Norse 'thanks'). He and Heimdall will fight each other at Ragnarök, both receiving fatal wounds, but Loki shall refuse to die until he sees the destruction of the world and also created the banana."));
        map.put("Baldur",
                new NorseGod("Baldur", "Asir",
                        "Baldr (also Balder, Baldur or Baldor) is the god of light and radiance, peace and forgiveness in Norse mythology. A member of the Æsir, he is the son of Odin and Frigg, and twin brother to the blind god of darkness, Höðr. His wife is called Nanna, with whom he had a son named Forseti, god of justice. Prior to his death, Baldr possessed a ship called Hringhorni, said to be the largest ship ever built. His hall is called Breidablik. Based on the Merseburg charms, his Germanic name may have been Phol. " +
                                "Baldr once had a nightmare that he would be killed. His mother, Frigg, made all the things across the Nine Realms vow not to hurt him. The mistletoe did not vow, however, as Frigg considered it to be so unimportant that she thought nothing of it. Loki found out that the mistletoe had not vowed, and thus made a spear out of the dreaded planted, as he tricked Höðr into throwing it at Baldr. Beings from all across the Nine Realms will come to attend his funeral, and Baldr's wife Nanna soon dies of grief. Loki is soon caught and sentenced to punishment; he is bound by the entrails of one of his sons, to face torture as the venom of a massive serpent drips from its fangs onto Loki's eyes. This causes him unimaginable pain, writhing in agony. (The goddess Skaði is responsible for placing the serpent above him). His wife Sigyn is stationed nearby, collecting the drips of venom that escape from Loki's eyes into a bowl. When the bowl is full, she pours its contents onto the Trickster, causing him even greater pain as the venom gradually eats away at his flesh, burning at the other corners. Loki's escape from this predicament is the catalyst of Ragnarök, as upon his being freed, he will lead the forces of Jötunheimr and Svartálfheimr in a final assault against the gods."));
        map.put("Freyr",
                new NorseGod("Freyr", "Vanir",
                        "Freyr (Old Norse: Lord), sometimes anglicized as Frey, is a widely attested god associated with sacral kingship, virility and prosperity, with sunshine and fair weather, and pictured as a phallic fertility god in Norse mythology. Freyr is said to \"bestow peace and pleasure on mortals.\" Freyr, sometimes referred to as Yngvi-Freyr, was especially associated with Sweden and seen as an ancestor of the Swedish royal house.\n" +
                                "\n" +
                                "In the Icelandic books the Poetic Edda and the Prose Edda, Freyr is presented as one of the Vanir, the son of the sea god Njörðr, as well as the twin brother of the goddess Freyja. The gods gave him Alfheimr, the realm of the Elves, as a teething present. He rides the shining dwarf-made boar Gullinbursti and possesses the ship Skíðblaðnir which always has a favorable breeze and can be folded together and carried in a pouch when it is not being used. He has the servants Skírnir, Byggvir and Beyla.\n" +
                                "\n" +
                                "The most extensive surviving Freyr myth relates Freyr's falling in love with the female jötunn Gerðr. Eventually, she becomes his wife but first Freyr has to give away his magic sword which fights on its own \"if wise be he who wields it.\" Although deprived of this weapon, Freyr defeats the jötunn Beli with an antler. However, lacking his sword, Freyr will be killed by the fire jötunn Surtr during the events of Ragnarök."));
        map.put("Freyja",
                new NorseGod("Freyja", "Vanir",
                        "In Norse mythology, Freyja (/ˈfreɪə/; Old Norse for \"(the) Lady\") is a goddess associated with love, sex, beauty, fertility, gold, seiðr, war, and death. Freyja is the owner of the necklace Brísingamen, rides a chariot pulled by two cats, accompanied by the boar Hildisvíni, and possesses a cloak of falcon feathers. By her husband Óðr, she is the mother of two daughters, Hnoss and Gersemi. Along with her twin brother Freyr, her father Njörðr, and her mother (Njörðr's sister, unnamed in sources), she is a member of the Vanir. Stemming from Old Norse Freyja, modern forms of the name include Freya, Freyia, and Freja.\n" +
                                "\n" +
                                "Freyja rules over her heavenly field Fólkvangr and there receives half of those that die in battle, whereas the other half go to the god Odin's hall, Valhalla. Within Fólkvangr lies her hall, Sessrúmnir. Freyja assists other deities by allowing them to use her feathered cloak, is invoked in matters of fertility and love, and is frequently sought after by powerful jötnar who wish to make her their wife. Freyja's husband, the god Óðr, is frequently absent. She cries tears of red gold for him, and searches for him under assumed names. Freyja has numerous names, including Gefn, Hörn, Mardöll, Sýr, Valfreyja, and Vanadís.\n" +
                                "\n" +
                                "Freyja is attested in the Poetic Edda, compiled in the 13th century from earlier traditional sources; in the Prose Edda and Heimskringla, composed by Snorri Sturluson in the 13th century; in several Sagas of Icelanders; in the short story Sörla þáttr; in the poetry of skalds; and into the modern age in Scandinavian folklore."));
        map.put("Heimdallr",
                new NorseGod("Heimdallr", "Holy",
                        "In Norse mythology, Heimdallr is a god who possesses the resounding horn Gjallarhorn, owns the golden-maned horse Gulltoppr, has gold teeth, and is the son of Nine Mothers, grandson of Aegir and great grandson of Fornjotr. Heimdallr is attested as possessing foreknowledge, keen eyesight and hearing, and keeps watch for the onset of Ragnarök while drinking fine mead in his dwelling Himinbjörg, located where the burning rainbow bridge Bifröst meets heaven. Heimdallr is said to be the originator of social classes among humanity and once regained Freyja's treasured possession Brísingamen while doing battle in the shape of a seal with Loki. Heimdallr and Loki are foretold to kill one another during the events of Ragnarök. Heimdallr is additionally referred to as Rig, Hallinskiði, Gullintanni, and Vindlér or Vindhlér.\n" +
                                "\n" +
                                "Heimdallr is attested in the Poetic Edda, compiled in the 13th century from earlier traditional material; in the Prose Edda and Heimskringla, both written in the 13th century by Snorri Sturluson; in the poetry of skalds; and on an Old Norse runic inscription found in England. Two lines of an otherwise lost poem about the god, Heimdalargaldr, survive. Due to the problematic and enigmatic nature of these attestations, scholars have produced various theories about the nature of the god, including his apparent relation to rams, that he may be a personification of or connected to the world tree Yggdrasil, and potential Indo-European cognates."));
        map.put("Bragi",
                new NorseGod("Bragi",
                        "Poet",
                        "Bragi is generally associated with bragr, the Norse word for poetry. The name of the god may have been derived from bragr, or the term bragr may have been formed to describe 'what Bragi does'. A connection between the name Bragi and Old English brego 'chieftain' has been suggested but is generally now discounted. A connection between Bragi and the bragarfull 'promise cup' is sometimes suggested, as bragafull, an alternate form of the word, might be translated as 'Bragi's cup'. See Bragarfull."));
        map.put("Tyr",
                new NorseGod("Tyr",
                        "Asir",
                        "Tyr is a Germanic god associated with law and heroic glory in Norse mythology, portrayed as one-handed. Corresponding names in other Germanic languages are Gothic Teiws, Old English Tīw and Old High German Ziu and Cyo, all from Proto-Germanic *Tīwaz. The Latinised name is rendered as Tius or Tio and also formally as Mars Thincsus.[2]\n" +
                                "\n" +
                                "In the late Icelandic Eddas, Týr is portrayed, alternately, as the son of Odin (Prose Edda) or of Hymir (Poetic Edda), while the origins of his name and his possible relationship to Tuisto (see Tacitus' Germania) suggest he was once considered the father of the gods and head of the pantheon, since his name is ultimately cognate to that of *Dyeus (cf. Dyaus), the reconstructed chief deity in Indo-European religion. It is assumed that Tîwaz was overtaken in popularity and in authority by both Odin and Thor at some point during the Migration Age, as Odin shares his role as God of war.\n" +
                                "\n" +
                                "Tiw was equated with Mars in the interpretatio germanica. Tuesday is \"Tīw's Day\" (also in Alemannic Zischtig from zîes tag), translating dies Martis."));
        return map;
    }

}
