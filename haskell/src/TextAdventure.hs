module TextAdventure (
  GameState(..),
  gameLoop,
) where

data GameState gameData =
  End String |
  -- ^ The game should end after showing the user a farewell message
  Continue gameData String
  -- ^ The game should continue with the updated gameData and the next prompt message

{-
  A helper function to drive your game.

  1) Define a custom data type `gameData` which represents your game's internal logical state.

  2) Define your game's main logic function which takes the current game data, a line of input
  from the user, and returns a new GameState

  3) Start your game by calling `gameLoop initialGameData initialPrompt gameLogic` in your `main` function
-}
gameLoop ::
     gameData
  -> String -- a text prompt to show the user
  -> (gameData -> String -> GameState gameData)
  -> IO ()
gameLoop gameData prompt gameLogic = do
    input <- getInput prompt
    case gameLogic gameData input of
      End farewell ->
        putStrLn farewell
      Continue nextGameData nextPrompt ->
        gameLoop nextGameData nextPrompt gameLogic
  where
    getInput :: String -> IO String
    getInput prompt = putStrLn prompt >> getLine

