package utilz;

import entities.Character;
import utilz.Constants.PlayerConstants;

import java.util.HashMap;
import java.util.Map;

public class CharacterManager {
    private Map<String, Character> characters;

    public CharacterManager() {
        characters = new HashMap<>();
        initCharacters();
    }

    private void initCharacters() {
        // Initialize characters with their respective sprite sheets and actions
        characters.put("Naruto", new Character("Uzumaki Naruto", "sprite1.png", Map.of(
                PlayerConstants.IDLE, 5,
                PlayerConstants.RUNNING, 6,
                PlayerConstants.HIT, 4
                // Add other actions as needed
        )));
        characters.put("Sakura", new Character("Sakura", "Sakura.png", Map.of(
                PlayerConstants.IDLE, 4,
                PlayerConstants.RUNNING, 6,
                PlayerConstants.HIT, 3
                // Add other actions as needed
        )));
        // Add more characters as needed
    }

    public Character getCharacter(String name) {
        return characters.get(name);
    }
}
