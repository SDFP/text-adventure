const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

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

/*
  Define a function to drive your game.
  The function will need to take the current game state, the response
  from the user and calculate the next game state.

  Pass that function, along with some initial data and prompt to
  the loop function.

  When ending, the game should first show a farewell message.
  When continuing, the game should show prompt & await user input
*/


module.exports = () => {
  console.log('do something like: `loop(initData, initPrompt, runFn)`');
}
