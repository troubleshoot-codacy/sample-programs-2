def next_state(board):
    """
    Compute the next iteration of Conway's Game of Life.

    Args:
        board: 2D list (matrix) of cells. Each cell is treated as alive if truthy, dead if falsy.

    Returns:
        A new 2D list of the same dimensions representing the next state.
    """

    if not board:
        return []

    num_rows = len(board)
    num_cols = len(board[0]) if num_rows > 0 else 0

    # Normalize input to 0/1 and build a zero-padded board to avoid boundary checks
    zero_row = [0] * (num_cols + 2)
    padded = [zero_row[:]]
    for r in range(num_rows):
        padded.append([0] + [1 if board[r][c] else 0 for c in range(num_cols)] + [0])
    padded.append(zero_row[:])

    next_board = [[0 for _ in range(num_cols)] for _ in range(num_rows)]

    for r in range(num_rows):
        pr = r
        r1 = r + 1
        r2 = r + 2
        for c in range(num_cols):
            c0 = c
            c1 = c + 1
            c2 = c + 2

            # Sum the 8 neighbors directly from the padded board
            live_neighbors = (
                padded[pr][c0] + padded[pr][c1] + padded[pr][c2]
                + padded[r1][c0] +                 padded[r1][c2]
                + padded[r2][c0] + padded[r2][c1] + padded[r2][c2]
            )

            alive = padded[r1][c1]
            # Any live cell with two or three neighbors survives; any dead cell with exactly three becomes live
            next_board[r][c] = 1 if (live_neighbors == 3 or (live_neighbors == 2 and alive)) else 0

    return next_board


