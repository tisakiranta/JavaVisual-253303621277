import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.2 — CRUD Test ===\n");

        CharacterManager manager = new CharacterManager();

        // 1. Menambahkan karakter
        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5));

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3));

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4));

        // 2. Menguji nama duplikat
        System.out.println();

        manager.addCharacter(
                new Character("Arjuna", CharacterType.HEALER, 1));

        // 3. Menghitung total karakter
        System.out.println("\nTotal karakter saat ini: "
                + manager.getTotalCharacters());

        // 4. Mencari karakter
        System.out.println("\n--- Pencarian ---");

        Character hasil = manager.findByName("Merlin");

        System.out.println(hasil != null
                ? "Ditemukan: " + hasil
                : "Tidak ditemukan");

        Character tidakAda = manager.findByName("Zeus");

        System.out.println(tidakAda != null
                ? "Ditemukan: " + tidakAda
                : "Zeus tidak ditemukan (sesuai harapan)");

        // 5. Menghapus karakter
        System.out.println("\n--- Penghapusan ---");

        manager.removeCharacter("Athena");

        System.out.println("Total setelah hapus: "
                + manager.getTotalCharacters());

        // 6. Menampilkan semua karakter
        System.out.println("\n--- Daftar Karakter Tersisa ---");

        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }

        // 7. Eksperimen Object Reference
        System.out.println("\n--- Eksperimen Reference ---");

        Character asli = manager.findByName("Arjuna");

        Character duplikatReferensi = asli;

        System.out.println("Level Arjuna sebelum: "
                + asli.getLevel());

        duplikatReferensi.setLevel(99);

        System.out.println("Level Arjuna sesudah (lewat 'asli'): "
                + asli.getLevel());

        System.out.println("asli == duplikatReferensi? "
                + (asli == duplikatReferensi));

        // Menguji salinan list
        java.util.ArrayList<Character> salinanList =
                manager.getAllCharacters();

        salinanList.add(
                new Character("Hantu", CharacterType.MAGE, 1));

        System.out.println("Total di manager asli: "
                + manager.getTotalCharacters());

        System.out.println("Total di salinan list : "
                + salinanList.size());

        // 8. Mini-challenge: rata-rata level
        System.out.println("\n--- Rata-rata Level ---");

        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        // 9. Mini-challenge: mencari berdasarkan tipe
        System.out.println("\n--- Karakter Bertipe WARRIOR ---");

        for (Character c : manager.findByType(CharacterType.WARRIOR)) {
            System.out.println(c);
        }
    }
}
