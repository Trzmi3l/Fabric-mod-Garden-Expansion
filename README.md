
# Garden Expansion

Modyfikacja do gry Minecraft dodajaca troche nowej funkcjonalnosci do gry




## Autorzy

- [@Keameleek](https://github.com/Trzmi3l) Kamil Marzenowski
- [@vinamon](https://github.com/vinamon) Marceli Denysiuk



## Wymagania

   - Minecraft 1.20.4 z Fabric loaderem (https://fabricmc.net/)
   - Fabric API: (https://www.curseforge.com/minecraft/mc-mods/fabric-api/files/5045131)
   - Owo Lib: (https://www.curseforge.com/minecraft/mc-mods/owo-lib/files/5043211)
   - GeckoLib: (https://www.curseforge.com/minecraft/mc-mods/geckolib/files/5188390)


## Co dodane

- Garsc lisci
- Zestaw zbroi z lisci, ktory przy pelnym zalozeniu dale Szczescie 2
- Calkowicie nowe drewno i drzewa - Klon
- Obornik
- Blok blota
- Sekator
- Kore
- Syrop klonowy
- Kranik do pozyskiwania syropu klonowego
- Zbieracz wody deszczowej
- Krate do rosnil pnacych
- Osobna karta w menu kreatywnym dla itemow z modyfikacji



## Usprawnienia w kodzie 

- Rejestracja itemow i blokow

   Optymalizacja na poziomie rejestru ficzerow jest jedna z najbardziej kluczowych poniewaz bardzo skrocilismy proces uzywajac biblioteki OwoLib.

   - Klasyczny przykladowy sposob rejestracji: 
   ```Java
   public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
            
            private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TutorialMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TutorialMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
   ```
   Jak widac potrzebne sa az 2 metody i rozlegle skonfigurowanie blocku/itemu, ktory chcemy zarejestrowac.

   - Przyklad rejestracji przy Uzyciu OwoLib:

   Klasa RegisterBlocks dostepna w src moda:
   ```Java
   public class RegisterBlocks implements BlockRegistryContainer {

         public static final Block BARK_BLOCK = new BarkBlock();

         @Override
         public BlockItem createBlockItem(Block block, String identifier) {
            return new BlockItem(block, new OwoItemSettings().group(Gardenexpansion.ITEM_GROUP));
      }
   }
   ```
   Klasa BarkBlock: 
   ```Java
   public class BarkBlock extends Block {

         public static final BlockSoundGroup BARK_BLOCK_SOUNDS = new BlockSoundGroup(1.0f, 1.0f, SoundEvents.BLOCK_MANGROVE_ROOTS_BREAK, SoundEvents.BLOCK_WART_BLOCK_STEP, SoundEvents.BLOCK_WART_BLOCK_PLACE, SoundEvents.BLOCK_WART_BLOCK_HIT, SoundEvents.BLOCK_WART_BLOCK_FALL);

         static FabricBlockSettings BarkBlockSettings = FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BARK_BLOCK_SOUNDS);


         public BarkBlock() {
            super(BarkBlockSettings);
      }

   }  
   ```
   Oszczedzamy miejsce na potencjalne bledy i usprawniamy prace rejestrujac niesamowicie prosto kazdy block i item jaki chcemy tylko dodac. Wiecej o rejestracji tutaj: (https://docs.wispforest.io/owo/registration/).
   Uzywajac OwoLib dodajemy za jednym zamachem wszytko do zakladki w inventory menu kreatywnego.

- Generowanie danych
      
   Generujac dane takie jak Tagi, Tabele dropow, modele, blockstaty i craftingi zamiast pisania ich recznie daje mozliwosci tworzenia masowej ilosci dancyh json, ktore sa potrzebne do rpawidlowego zachowania bloku/itemu.
   - Wszytskie klasy generujace znajduja sie tutaj: (https://github.com/Trzmi3l/Fabric-mod-Garden-Expansion/tree/Master/src/main/java/com/gardenexpansion/datagen)

- Nadawanie koloru bloku lisci klonu
   
   Kolor lisci nadawany jest przez ColorProvider zamiast przez osobna teksture
     - Dla bloku
         ```Java
       ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if(world == null || pos == null) {
                return colorProvider.getColor(state, world, pos, tintIndex);
            }
                return colorProvider.getColor(state, world, pos, tintIndex);
        }), RegisterBlocks.MAPLE_LEAVES
        );
         ```
      
   - Dla itemu
      ```Java
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return colorProvider.getColor();
        }, RegisterBlocks.MAPLE_LEAVES.asItem());
      ```

      Metoda getColor zwraca Int i nadaje tym samym kolor lisciom.
      
      Metoda nadania kolou w ten sposob umozliwia zmiane koloru zmieniajac tylko jedna wartosc dzieki czemu nie trzeba wiele razy tworzyc tekstury dla jednego bloku/itemu
      


# Graficzne przedstawienie dodanych funkcji

- Zbroja z trawy

   ![](images/grassarmor.png)

- Zebranie garstki lisci sekatorem

   ![](images/prunerUsage.gif)

- Zebranie kory poprzec okoronowanie drzewa

   ![](images/barkobtain.gif)

- Pozyskiwanie obornika

   ![](images/manureobtain.gif)

- Uzycie obornika

   ![](images/manureusage.gif)

- Uzycie kranika do zbierania syropu

   ![](images/tapusage.gif)

- Zestawienie wszytskich featurow

   ![](images/showcase.png)


## TODO

- Naturalny spawn drzew klonu
- Poprawienie zbugowanego water collectora

## Skad czerpalismy wiedze

   - https://fabricmc.net/wiki/tutorial:start#creating_your_first_mod
   - https://www.youtube.com/watch?v=0Pr_iHlVKsI&list=PLKGarocXCE1EO43Dlf5JGh7Yk-kRAXUEJ
   - https://maven.fabricmc.net/docs/yarn-1.20-pre4+build.3/allclasses-index.html
   - https://github.com/Tutorials-By-Kaupenjoe/Fabric-Tutorial-1.20.X/tree/main
   - Chat GPT
   - Google Gemini


