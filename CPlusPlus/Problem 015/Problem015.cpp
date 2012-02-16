/*
Project Euler
Problem 015
"Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking) to the bottom right corner.

How many routes are there through a 20x20 grid?"
*/

#include <iostream>
#include <windows.h> // for UINT64

struct vertex 
{	
	int x;
	int y;
};

#define WIDTH  21
#define HEIGHT 21

vertex graph[HEIGHT][WIDTH][2];
UINT64 costs[HEIGHT][WIDTH];

void
populateGraph(vertex the_graph[HEIGHT][WIDTH][2])
{
	for (int y=0; y<HEIGHT; ++y)
	{
		for (int x=0; x<WIDTH; ++x)
		{
			if (x < WIDTH-1)
			{
				graph[y][x][0].x = x+1;
				graph[y][x][0].y = y;
			}
			else
			{
				graph[y][x][0].x = -1;
				graph[y][x][0].y = -1;

			}
			if (y < HEIGHT - 1)
			{
				graph[y][x][1].x = x;
				graph[y][x][1].y = y+1;
			}
			else
			{
				graph[y][x][1].x = -1;
				graph[y][x][1].y = -1;
			}
		}
	}
}

void
populateCosts(UINT64 costs[HEIGHT][WIDTH])
{
	for (int y=0; y<HEIGHT; ++y)
	{
		for (int x=0; x<WIDTH; ++x)
		{
			costs[y][x] = 0;
		}
	}
	costs[HEIGHT-1][WIDTH-1] = 1;
}

UINT64
calculateCost(int x, int y, UINT64 costs[HEIGHT][WIDTH], vertex graph[HEIGHT][WIDTH][2])
{
	if (costs[y][x] != 0)
	{
		return costs[y][x];
	}
	int a1, b1, a2, b2;
	UINT64 cost1, cost2;
	a1 = graph[y][x][0].x;
	b1 = graph[y][x][0].y;
	a2 = graph[y][x][1].x;
	b2 = graph[y][x][1].y;


	if (a1 != -1)
		cost1 = calculateCost(a1, b1, costs, graph);
	else
		cost1 = 0;
	if (a2 != -1)
		cost2 = calculateCost(a2, b2, costs, graph);
	else
		cost2 = 0;

	costs[y][x] = cost1 + cost2;
	return cost1+cost2;
}

int
main (void)
{
	// populate graph
	populateGraph(graph);

	// populate costs
	populateCosts(costs);

	// calculate costs
	calculateCost(0, 0, costs, graph);

	// now, costs[0][0] should hold the answer
	std::cout << "Total number of paths: " << costs[0][0] << std::endl;
}
