
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
   Oszczedzamy miejsce na potencjalne bledy i usprawniamy prace rejestrujac niesamowicie prosto kazdy block i item jaki chcemy tylko dodac. Wiecej o rejestracji tutaj: (https://docs.wispforest.io/owo/registration/)

