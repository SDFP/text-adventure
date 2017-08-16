const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// When ending, the game should first show a farewell message.
// When continuing, the game should show prompt & await user input

/*
  Define a function to drive your game.
  The function will need to take the current game state, the response
  from the user and calculate the next game state.
*/

const loop = (gameData, prompt, run) => {
  rl.question(prompt, (resp) => {
    const { end, cont } = run(gameData, resp);

    if (end) {
      console.log(end.farewell);
      rl.close();
    } else {
      loop(cont.data, cont.prompt, run)
    }
  });
}

const main = () => {
  console.log('Running the loop');
  loop(initGameState, "You ready?", runIt)
}

module.exports = main();
