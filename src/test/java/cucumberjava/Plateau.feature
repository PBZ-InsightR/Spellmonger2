Feature: Cucumberjava

Scenario: InitMain

Given a game exists

Given current hand is empty

When InitMain is called

Then current hand is composed of 3 cards

Scenario: Pioche

Given a game exists

When Pioche is called

Then the card is add in current hand

Scenario: a winner  exists

Given a game exists

When a player have 0 or less hp

Then a winner exists

Scenario: getNbTours

Given a game exists

When a turn end

Then the number of turns increase by 1

Scenario: getCurrent

Given a game exists

Then getCurrent return the current player

Scenario: getWinner

Given a game exists

When p1 beat p2

Then getWinner return the name of the player winning

Scenario: bataille if current board empty, opponent board empty and cardChoosen is a bear

Given a game exists

Given p1 board is empty

Given p2 board is empty

Given p1 cardChoosen is a bear

When bataille is called

Then p2 loose 3 hp
