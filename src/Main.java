
import java.util.ArrayList;
import javax.swing.SwingUtilities;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;

public class Main {

    public static void main(String[] args) {

        CharacterManager manager = new CharacterManager();

        // Lima karakter sebelumnya
        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5)
        );

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3)
        );

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4)
        );

        manager.addCharacter(
                new Character("Laksmi", CharacterType.HEALER, 6)
        );

        manager.addCharacter(
                new Character("Bima", CharacterType.WARRIOR, 7)
        );

        // Karakter keenam
        manager.addCharacter(
                new Character("Morgana", CharacterType.MAGE, 1)
        );

        ArrayList<Character> dataKarakter =
                manager.getAllCharacters();

        SwingUtilities.invokeLater(() -> {

            MainWindow window = new MainWindow(dataKarakter);

            window.setVisible(true);
        });
    }
}
