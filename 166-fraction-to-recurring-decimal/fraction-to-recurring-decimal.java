public class Solution {
    // Method to convert a fraction to a decimal string
    public String fractionToDecimal(int numerator, int denominator) {
        // If numerator is zero, return "0"
        if (numerator == 0) {
            return "0";
        }
        
        // StringBuilder to store the result
        StringBuilder res = new StringBuilder();
        
        // Determine the sign of the result
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        
        // Convert numerator and denominator to long to handle overflow
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // Append the integral part to the result
        res.append(num / den);
        
        // Calculate the remainder after division
        num %= den;
        
        // If remainder is zero, return the result
        if (num == 0) {
            return res.toString();
        }
        
        // Append the fractional part
        res.append(".");
        
        // HashMap to store the position of each remainder in the result
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        
        // Loop to calculate the fractional part
        while (num != 0) {
            // Multiply the remainder by 10 and append the quotient to the result
            num *= 10;
            res.append(num / den);
            num %= den;
            
            // If the remainder is already in the map, it indicates a repeating decimal
            if (map.containsKey(num)) {
                // Insert "(" before the repeating part and ")" after it
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            // Otherwise, add the remainder and its position to the map
            else {
                map.put(num, res.length());
            }
        }
        // Return the final result
        return res.toString();
    }
}
