function solution(positions) {
    const rays = positions.reduce((accumulator, { x, y }) => {
        if (x === 0) {
            const gradient = y > 0 ? Number.POSITIVE_INFINITY : Number.NEGATIVE_INFINITY;
            accumulator[gradient] = 1;
        } else {
            const gradient = y / x;
            if (accumulator[gradient] === undefined) {
                accumulator[gradient] = x > 0 ? 1 : -1;
            } else if (x > 0 && accumulator[gradient] < 0 || x < 0 && accumulator[gradient] > 0) {
                accumulator[gradient] = 2;
            }
        }
        return accumulator;
    }, {});
    // Let's sum
    let rayCount = 0;
    for (let key in rays) {
        if (rays.hasOwnProperty(key)) {
            rayCount += Math.abs(rays[key]);
        }
    }
    return rayCount;
}


// TEST CASES
console.log(solution([{ x: 0, y: 1 }, { x: 2, y: 2 }]));    // 2
console.log(solution([{ x: 1, y: 1 }, { x: -1, y: 1 }, { x: -1, y: -1 }, { x: 1, y: -1 }]));    // 4
console.log(solution([{ x: 3, y: 1 }, { x: 4, y: 2 }]));    // 2
console.log(solution([{ x: 0, y: 1 }, { x: 0, y: -4 }, { x: 4, y: 4 }]));   // 3
console.log(solution([{ x: 1, y: 2 }, { x: 4, y: 8 },  { x: -6, y: 4 }, { x: -2, y: -1 }, { x: 2, y: -2 }]));   // 4
