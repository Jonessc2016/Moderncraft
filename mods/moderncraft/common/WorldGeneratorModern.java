package mods.moderncraft.common;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorModern implements IWorldGenerator {

	 @Override
	  public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	    // this checks the dimension of the current world that is loading
	    switch (world.provider.dimensionId) {
	      case 1:
	        generateEnd(world, random, chunkX * 16, chunkZ * 16);
	      case 0:
	        generateSurface(world, random, chunkX * 16, chunkZ * 16);
	      case -1:
	        generateNether(world, random, chunkX * 16, chunkZ * 16);
	    }
	  }

	  private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
	    // sets which blocks generate in the end, does not mean that one block
	    // cannot generate on several dimensions
	  }

	  private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
	    // sets which blocks can generate on the overworld, does not mean that
	    // one block cannot generate on several dimensions
	    for (int i = 0; i < 50; i++) {
	      int coordX = random.nextInt(16) + chunkX;
	      // sets the height to be a random number below 64
	      int coordY = random.nextInt(64);
	      int coordZ = random.nextInt(16) + chunkZ;

	      // actually puts the block in the world
	      (new WorldGenMinable(modern.CopperOre.blockID, 8)).generate(world, random, coordX, coordY, coordZ);
	      (new WorldGenMinable(modern.TinOre.blockID, 8)).generate(world, random, coordX, coordY, coordZ);
	      (new WorldGenMinable(modern.SilverOre.blockID, 8)).generate(world, random, coordX, coordY, coordZ);
	      (new WorldGenMinable(modern.LeadOre.blockID, 8)).generate(world, random, coordX, coordY, coordZ);
	      (new WorldGenMinable(modern.TungstenOre.blockID, 2)).generate(world, random, coordX, coordY, coordZ);
	      (new WorldGenMinable(modern.UraniumOre.blockID, 4)).generate(world, random, coordX, coordY, coordZ);
	    }
	  }

	  private void generateNether(World world, Random random, int chunkX, int chunkZ) {
	    // sets which blocks generate in the nether, does not mean that one
	    // block cannot generate on several dimensions
	  }

	}